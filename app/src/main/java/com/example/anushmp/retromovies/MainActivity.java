package com.example.anushmp.retromovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    TextView apiresponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiresponse = findViewById(R.id.apiresponse);

        //Retrofit browser = Networker.

        Log.d("geraldford", "onCreate: ");

       //Networker m = new Networker();

       Retrofit browser = Networker.getRetrofit();

       Api api = browser.create(Api.class);

       api.getMovies().enqueue(new Callback<ApiResponse>() {
           @Override
           public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

               Log.d("bobby", "hello from onresponse");

               MainActivity.this.runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       Log.d("bobby", "hello from onresponse");
                   }
               });


              // ApiResponse resp = response.body();

               //List<ComingSoon> cslist = resp.getComingSoon();
              // ComingSoon cs1 = cslist.get(0);

               //String test = cs1.getTitle();

               //apiresponse.setText(test);



              // Log.d("geraldford", "onResponse: ");
               //String out = "nothing found";
              // apiresponse.setText(out);
              //if(response != null){out = response.body().toString();}

              // apiresponse.setText(out);

               //Log.d("geraldford ", "onResponse: ");

           }

           @Override
           public void onFailure(Call<ApiResponse> call, Throwable t) {

               MainActivity.this.runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       Log.d("bobby", "failed");
                   }
               });

           }
       });


        String url = "https://gist.githubusercontent.com/Dcosta2205/cd3bf4cfdf6911fb26ae95672adb468e/raw/62d68fac146598cdba379317011ac9aa1aca8621/movies_db/";

        OkHttpClient k = new OkHttpClient();
        Request.Builder rb = new Request.Builder();
        rb.url(url);
        Request resreq = rb.build();

        k.newCall(resreq).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {

                String outfromresp = response.body().toString();

                okhttp3.Response r = response;

                String o = r.body().string();



                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        apiresponse.setText(o);
                    }
                });

                //apiresponse.setText(outfromresp);

                Log.d("bobby", outfromresp);

            }
        });




    }
}