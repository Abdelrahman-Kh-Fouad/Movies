package com.example.movies.recycler;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.R;

import org.w3c.dom.Text;

public class MoviesRecyclerViewViewHolder extends RecyclerView.ViewHolder {
    private TextView name ;
    private TextView rate ;
    private ImageView img ;

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getRate() {
        return rate;
    }

    public void setRate(TextView rate) {
        this.rate = rate;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public MoviesRecyclerViewViewHolder(@NonNull View itemView) {
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.movie_name);
        rate = (TextView)itemView.findViewById(R.id.movie_rate);
        img = (ImageView)itemView.findViewById(R.id.movie_img);
    }
}
