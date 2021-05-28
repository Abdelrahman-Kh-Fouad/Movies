package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.movies.Pages.BasicActivity;
import com.example.movies.data.ApiRequests;
import com.example.movies.pojo.Movie;

import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent( MainActivity.this, BasicActivity.class);

        bt =(Button) findViewById(R.id.testbuttob);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        try {
            test();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    void test () throws JSONException {
        ApiRequests op = new ApiRequests(this);
        op.FillPopularMoviesReposetory();
//        ArrayList<Movie> res = (ArrayList<Movie>) op.GetMovies(4);
//        for (Movie cur : res){
//            Log.d("check", "test: "+cur.name);
//        }
    }

}