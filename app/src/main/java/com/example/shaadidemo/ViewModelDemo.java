package com.example.shaadidemo;

import android.app.Application;
import android.util.Log;

import com.example.shaadidemo.Data.Results;
import com.example.shaadidemo.Retrofitt.Api;
import com.example.shaadidemo.Retrofitt.JSONResponse;
import com.example.shaadidemo.Retrofitt.SingletonRetrofit;
import com.example.shaadidemo.RoomDataBase.DataBaseRepository;
import com.example.shaadidemo.RoomDataBase.ProfileEntity;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelDemo extends AndroidViewModel {

    private DataBaseRepository personRepository;
//    private LiveData<Integer> insertResult;
    private LiveData<List<ProfileEntity>> resultList;

    public ViewModelDemo(Application application) {
        super(application);
        personRepository = new DataBaseRepository(application);
    }

    public void insert(ProfileEntity profileEntity) {
        personRepository.insert(profileEntity);
    }

    public LiveData<List<ProfileEntity>> getResultFromRepo() {
        return personRepository.getProfileFromRoom();
    }

    public LiveData<List<ProfileEntity>> insertProfilesFromJsontoRoom() {
        if (resultList == null) {
            resultList = new MutableLiveData<>();
            loadFromRetrofit();
        }
        return resultList;
    }

    private void loadFromRetrofit() {
        Api api = SingletonRetrofit.getInstance().getJSONApi();
        Call<JSONResponse> call = api.getJson();

        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call,
                                   Response<JSONResponse> response) {
                if (response.code() == 200) {

                    ArrayList<Results> responseArray = response.body().getResults();
                    List<ProfileEntity> profileEntityList = new ArrayList<>();
                    for (Results result : responseArray) {
                        ProfileEntity profileEntity = new ProfileEntity();
                        profileEntity.setName(result.getName().getTitle() + " "
                                + result.getName().getFirst() + " "
                                + result.getName().getLast());
                        profileEntity.setGender(result.getGender());
                        profileEntity.setLocation(result.getLocation().getCity() + ", "
                                + result.getLocation().getState() + ", "
                                + result.getLocation().getCountry());
                        profileEntity.setEmail(result.getEmail());
                        profileEntity.setAge(result.getDob().getAge());
                        profileEntity.setPicture(result.getPicture().getMedium());
                        profileEntity.setLogin_uuid(result.getLogin().getUuid());
                        profileEntity.setStatus("STATUS_NA");
                        profileEntityList.add(profileEntity);
                        insert(profileEntity);
                    }
                }
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("EXCEPTION DURING FETCH", String.valueOf(t.getMessage()));
            }
        });
    }

    public void updateStatus(String status_accept, String login_uuid) {
        personRepository.updateStatus(status_accept, login_uuid);
    }
}