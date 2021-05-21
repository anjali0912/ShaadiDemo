package com.example.shaadidemo.RoomDataBase;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ProfileDao {

    @Query("SELECT * FROM profile DATABASE_PROFILE")
    LiveData<List<ProfileEntity>> getAllProfileFromRoom();

    @Insert
    void insertProfileIntoRoom(ProfileEntity profileEntity);

    @Query("UPDATE profile SET status=:status WHERE login_uuid = :uuid")
    void updateProfileStatus(String status, String uuid);
}
