package com.example.movies.Pages.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movies.R;
import com.example.movies.db.MovieDAO;
import com.example.movies.db.MovieDataBase;
import com.example.movies.pojo.Movie;
import com.example.movies.recycler.MoviesRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SavedFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Movie>movies;

    public SavedFragment() { }
    public static SavedFragment newInstance() {
        SavedFragment fragment = new SavedFragment();
       return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) { }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_saved, container, false);
    }

    

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        movies = new ArrayList<Movie>();

        movies .addAll(MovieDataBase.getInstance(getContext()).movieDAO().getAllCars());

        recyclerView = (RecyclerView)view.findViewById(R.id.saved_fragment_recycler_view);
        MoviesRecyclerViewAdapter moviesRecyclerViewAdapter= new MoviesRecyclerViewAdapter(getContext() ,this ,movies);
        recyclerView.setAdapter(moviesRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }
}