package com.example.movies.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Update;

import com.example.movies.pojo.Movie;

import java.util.List;

@Dao
public interface MovieDAO {

    @Update
    Void Update(Movie movie);

    @Insert
    void insert(Movie movie);

    @Delete
    void Delete(Movie movie);

    @Query("SELECT * FROM movie_table")
    List<Movie> getAllCars();

    @Query("DELETE FROM movie_table")
    void deleteAllCars();

}
