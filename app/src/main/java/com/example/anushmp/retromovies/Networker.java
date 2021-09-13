package com.example.anushmp.retromovies;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Networker {

    private static final String base_url = "https://gist.githubusercontent.com/Dcosta2205/cd3bf4cfdf6911fb26ae95672adb468e/raw/62d68fac146598cdba379317011ac9aa1aca8621/";

    public static Retrofit getRetrofit(){

        GsonConverterFactory gf = GsonConverterFactory.create();

        OkHttpClient.Builder htb = new OkHttpClient().newBuilder();


        htb.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        OkHttpClient htc = htb.build();
        //OkHttpClient htc = new OkHttpClient().newBuilder();



        //OkHttpClient htc2 = new OkHttpClient();

        Retrofit.Builder rfb = new Retrofit.Builder();

        rfb.baseUrl(base_url);

        rfb.addConverterFactory(gf);

        rfb.client(htc);

        Retrofit response1 = rfb.build();

        Retrofit response2 = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(gf)
                .client(htc)
                .build();


        return response2;



    }
}
