package com.example.movies.Pages.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;

import com.example.movies.R;
import com.example.movies.data.ApiRequests;
import com.example.movies.pojo.Movie;
import com.example.movies.recycler.MoviesRecyclerViewAdapter;

import org.json.JSONException;

import java.util.ArrayList;

public class AllFragment extends Fragment {

    private RecyclerView recyclerView ;

    public AllFragment() {}
    public static AllFragment newInstance() {
        AllFragment fragment = new AllFragment();
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) { }

//        recyclerView = (RecyclerView) getView().findViewById(R.id.all_fragment_recycler_view);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.all_fragment_recycler_view);
        ArrayList<Movie> movies = new ArrayList<Movie>();
        MoviesRecyclerViewAdapter moviesRecyclerViewAdapter = new MoviesRecyclerViewAdapter(getContext() , movies);
        recyclerView.setAdapter(moviesRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ApiRequests apiRequests = new ApiRequests(getContext(),moviesRecyclerViewAdapter , movies);
        try {
            apiRequests.FillPopularMoviesReposetory();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(movies.size());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_all, container, false);
    }
}