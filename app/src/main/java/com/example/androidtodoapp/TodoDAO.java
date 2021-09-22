package com.example.androidtodoapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TodoDAO {
    @Query("SELECT * FROM todos")
    List<Todo> getAll();

    @Insert
    void insertAll(Todo... todos);

    @Insert
    void insert(Todo todo);

    @Delete
    void delete(Todo todo);
}
