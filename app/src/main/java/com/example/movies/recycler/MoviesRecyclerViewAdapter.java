package com.example.movies.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.R;

import java.util.List;

public class MoviesRecyclerViewAdapter extends RecyclerView.Adapter<MoviesRecyclerViewViewHolder> {

    private List<?> movies;
    private LayoutInflater parentLayoutInFlater;

    public MoviesRecyclerViewAdapter(Context parent , List<?> movies){
        this.movies = movies;
        parentLayoutInFlater = LayoutInflater.from(parent);

    }
    @NonNull
    @Override
    public MoviesRecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MoviesRecyclerViewViewHolder(parentLayoutInFlater.inflate(R.layout.movie_item ,parent ,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesRecyclerViewViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
