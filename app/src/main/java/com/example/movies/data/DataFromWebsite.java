package com.example.movies.data;

import com.example.movies.pojo.Movie;

import java.util.List;

public interface DataFromWebsite {
    public List<Movie> GetMovies(int number);


}
