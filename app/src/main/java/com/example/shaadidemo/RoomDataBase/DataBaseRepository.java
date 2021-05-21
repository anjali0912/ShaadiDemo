package com.example.shaadidemo.RoomDataBase;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import androidx.lifecycle.LiveData;

public class DataBaseRepository {
    private final ProfileDao profileDao;
    private LiveData<List<ProfileEntity>> profileResult;

    public DataBaseRepository(Context context) {
        ProfileDataBase dataBase = ProfileDataBase.getDatabase(context);
        profileDao = dataBase.profileDao();
        profileResult = profileDao.getAllProfileFromRoom();
    }

    public LiveData<List<ProfileEntity>> getProfileFromRoom() {
        return profileResult;
    }

    public void insert(ProfileEntity profileEntity) {
        new insertAsyncTask(profileDao).execute(profileEntity);
    }

    public void updateStatus(String status_accept, String login_uuid) {
        updateTask(status_accept, login_uuid);
    }

    private class insertAsyncTask extends AsyncTask<ProfileEntity, Void, Void> {

        private ProfileDao mAsyncTaskDao;

        insertAsyncTask(ProfileDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(ProfileEntity... profileEntities) {
            mAsyncTaskDao.insertProfileIntoRoom(profileEntities[0]);
            return null;
        }
    }

    private void updateTask(String status, String uuid) {

        class UpdateTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                profileDao.updateProfileStatus(status, uuid);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Log.d("UPDATE>>>>",">>>>>>>>");
            }
        }

        UpdateTask ut = new UpdateTask();
        ut.execute();
    }
}