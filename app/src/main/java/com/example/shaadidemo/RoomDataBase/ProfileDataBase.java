package com.example.shaadidemo.RoomDataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ProfileEntity.class}, version = 1, exportSchema = false)
public abstract class ProfileDataBase extends RoomDatabase {
    public abstract ProfileDao profileDao();
    private static ProfileDataBase INSTANCE;

    static ProfileDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ProfileDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ProfileDataBase.class, "MyDb")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}