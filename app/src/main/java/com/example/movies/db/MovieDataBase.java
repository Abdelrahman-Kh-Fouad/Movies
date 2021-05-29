package com.example.movies.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.movies.pojo.Movie;

@Database(entities = {Movie.class}, version = 1)
abstract public class MovieDataBase extends RoomDatabase {
    public abstract MovieDAO movieDAO();

    private static MovieDataBase INSTANCE;
    private final static String DB_name="MoviesDB";

    public static synchronized MovieDataBase getInstance(Context baseContext) {
        if(INSTANCE!=null){
            INSTANCE = Room.databaseBuilder(baseContext , MovieDataBase.class , DB_name )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();

        }
        return INSTANCE;
    }



}
