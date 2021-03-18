package com.example.roomdatabase.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roomdatabase.listeners.UserInfoDao;
import com.example.roomdatabase.model.UserInfo;

@Database(entities = {UserInfo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserInfoDao taskDao();
}