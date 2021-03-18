package com.example.roomdatabase.listeners;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdatabase.model.UserInfo;

import java.util.List;

@Dao
public interface UserInfoDao {

    @Query("SELECT * FROM userinfo")
    List<UserInfo> getAll();

    @Insert
    void insert(UserInfo task);

    @Delete
    void delete(UserInfo task);

    @Update
    void update(UserInfo task);
}
