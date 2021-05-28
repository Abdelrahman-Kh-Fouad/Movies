package com.example.movies.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.R;
import com.example.movies.pojo.Movie;

import java.util.List;

public class MoviesRecyclerViewAdapter extends RecyclerView.Adapter<MoviesRecyclerViewViewHolder> {

    private List<Movie> movies;
    private LayoutInflater parentLayoutInFlater;

    public MoviesRecyclerViewAdapter(Context parent , List<Movie> movies){
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
        Movie currentMovie = movies.get(position);
        holder.getName().setText(currentMovie.getName());
        holder.getRate().setText(currentMovie.getRate());

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
