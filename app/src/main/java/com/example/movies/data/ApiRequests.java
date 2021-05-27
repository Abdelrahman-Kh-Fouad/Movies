package com.example.movies.data;
import android.content.Context;
import android.os.AsyncTask;
import com.example.movies.pojo.Movie;
import java.util.List;

public class ApiRequests  extends AsyncTask<String, String, String> implements DataFromWebsite{

    private Context context;
    private ApiUrl apiUrlHelper;
    
    public ApiRequests(Context context){
        this.context =context;
        apiUrlHelper = new ApiUrl(context);

    }
    @Override
    public List<Movie> GetMovies(int number) {
        return null;
    }
    @Override
    protected String doInBackground(String... strings) {



    }
}
