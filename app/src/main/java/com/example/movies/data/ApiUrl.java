package com.example.movies.data;

import android.content.Context;

import com.example.movies.R;

public class ApiUrl {

    private Context context;
    public ApiUrl(Context context){
        this.context=context;
    }
    private String AddKey(){
        return "?api_key="+context.getString(R.string.api_key);
    }
    String GetTrendingMovies(String media_type , String time_window){
        String result = context.getString(R.string.basic_url);
        result+="/" + media_type;
        result+="/" + time_window;
        result+=AddKey();
        return result;
    }


}
