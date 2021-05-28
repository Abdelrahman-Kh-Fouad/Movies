package com.example.movies.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movies.R;
import com.example.movies.data.ApiUrl;
import com.example.movies.pojo.Movie;

import java.util.List;

public class MoviesRecyclerViewAdapter extends RecyclerView.Adapter<MoviesRecyclerViewViewHolder> {

    private List<Movie> movies;
    private LayoutInflater parentLayoutInFlater;
    private Context parent;
    private ApiUrl apiUrl;
    private Fragment fragment;

    public MoviesRecyclerViewAdapter(Context parent , Fragment fragment, List<Movie> movies){
        this.movies = movies;
        parentLayoutInFlater = LayoutInflater.from(parent);
        apiUrl = new ApiUrl(parent);
        this.fragment =fragment;
    }
    @NonNull
    @Override
    public MoviesRecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MoviesRecyclerViewViewHolder(parentLayoutInFlater.inflate(R.layout.movie_item ,parent ,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesRecyclerViewViewHolder holder, int position) {
        Movie currentMovie = movies.get(position);
        Glide.with(fragment).load(apiUrl.GetImageUrl(currentMovie.getImg())).into(holder.getImg());
        holder.getName().setText(currentMovie.getName());
        holder.getRate().setText(currentMovie.getVoteAverage());
        System.out.println(apiUrl.GetImageUrl(currentMovie.getImg()));

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
