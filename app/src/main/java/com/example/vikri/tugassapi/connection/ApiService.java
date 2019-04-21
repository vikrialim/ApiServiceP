package com.example.vikri.tugassapi.connection;

import com.example.vikri.tugassapi.Model.SportResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("v1/json/1/search_all_teams.php")
    Call<SportResponse> getArtikel(//@Query("s=Soccer&c=Spain") String source,
                                   @Query("apiKey") String apiKey);
}
