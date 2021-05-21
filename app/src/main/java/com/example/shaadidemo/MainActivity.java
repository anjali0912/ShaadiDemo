package com.example.shaadidemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.shaadidemo.Adapter.ProfileAdapter;
import com.example.shaadidemo.RoomDataBase.ProfileEntity;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProfileAdapter mAdapter;
    ViewModelDemo profileViewModel;
    static int mPosition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_profile);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        profileViewModel = ViewModelProviders.of(this)
                .get(ViewModelDemo.class);

        if (InternetConnection.checkConnection(getApplicationContext())) {
            profileViewModel.insertProfilesFromJsontoRoom();
        }

        profileViewModel.getResultFromRepo().observe(this, new Observer<List<ProfileEntity>>() {
            @Override
            public void onChanged(List<ProfileEntity> profileEntityList) {
                mAdapter = new ProfileAdapter(MainActivity.this, profileEntityList);
                mAdapter.notifyDataSetChanged();
                if(mPosition != -1){
                    recyclerView.scrollToPosition(mPosition);
                }
                recyclerView.setAdapter(mAdapter);
            }
        });

    }

    public void updateStatusInRoom(String status_accept, String login_uuid, int position) {
        profileViewModel.updateStatus(status_accept, login_uuid);
        mPosition = position;
    }
}