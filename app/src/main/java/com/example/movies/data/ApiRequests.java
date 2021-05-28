package com.example.movies.data;
import android.content.Context;
import android.os.AsyncTask;
import com.example.movies.pojo.Movie;
import com.example.movies.recycler.MoviesRecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class ApiRequests implements DataFromWebsite{

    private Context context;
    private ApiUrl apiUrlHelper;
    //For pool movies
    private Queue<Movie> popularMoviesReposetory;
    private JSONObject jsonObject;
    private List<Movie>movies ;
    private MoviesRecyclerViewAdapter moviesRecyclerViewAdapter;


    public ApiRequests(Context context , MoviesRecyclerViewAdapter moviesRecyclerViewAdapter , List<Movie>movies){
        super();
        this.context =context;
        apiUrlHelper = new ApiUrl(context);
        this.movies = movies;
        this.moviesRecyclerViewAdapter = moviesRecyclerViewAdapter;

        //Pools init
        popularMoviesReposetory= new LinkedList<Movie>();
    }

    public void FillPopularMoviesReposetory() throws JSONException {
        HttpRequest request = new HttpRequest();
        request.execute(apiUrlHelper.GetTrendingMovies(Values.media_type.ALL , Values.time_window.WEEK));

    }
    public List<Movie> JSONArrayToMovies(){
            try {

                JSONArray jsonArray = jsonObject.getJSONArray("results");


                for(int i =0 ; i < jsonArray.length() ;i++){
                    JSONObject current = (JSONObject) jsonArray.get(i);
                    String name , voteAverge="" , imageUrl="";

                    if (current.isNull("name"))
                        name = current.getString("title");
                    else
                        name = current.getString("name");

                    if(!current.isNull("vote_average"))
                        voteAverge = current.getString("vote_average");

                    if(!current.isNull("poster_path"))
                        imageUrl = current.getString("poster_path");

                    movies.add(new Movie(  name , 1 , imageUrl,  voteAverge));
                    
                }
                moviesRecyclerViewAdapter.notifyDataSetChanged();

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return movies;
    }
    @Override
    public List<Movie> GetMovies(int number) {
        return null;
    }
//
//    @Override
//    public List<Movie> GetMovies(int number)  {
//        ArrayList<Movie>result =new ArrayList<Movie>();
//        for(int i =0 ;i < number ;i++){
//            result.add(GetOnePopualrMovie());
//        }
//        return result;
//    }

    private class HttpRequest extends AsyncTask<String, String, String>{
        public HttpRequest() {
            super();
        }

        @Override
        protected String doInBackground(String... Url) {
            String result ="";
            try {
                URL url = new URL(Url[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setReadTimeout(10000 );
                urlConnection.setConnectTimeout(15000);
                urlConnection.connect();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
                StringBuilder stringBuilder = new StringBuilder();

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }
                bufferedReader.close();
                result = stringBuilder.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String jsonString) {
            super.onPostExecute(jsonString);
            try {
                jsonObject = new JSONObject(jsonString);
                JSONArrayToMovies();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }




}
