package com.jiayou.owlbot.services;


import com.jiayou.owlbot.model.OwlBotResponse;
import com.jiayou.owlbot.model.Word;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface{
    @GET("dictionary/{dictionary}")
    Call<Word> getDictionary(@Path("dictionary") String dictionary);

}
