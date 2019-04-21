package com.example.vikri.tugassapi.Presenter;

import android.content.Context;

import com.example.vikri.tugassapi.Model.SportResponse;
import com.example.vikri.tugassapi.connection.BaseApp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private Context context;
    private MainView mainView;

    public MainPresenter(Context context, MainView mainView){
        this.context = context;
        this.mainView = mainView;
    }
    public void loadArtikel( String apiKey){
        BaseApp.service.getArtikel(apiKey).enqueue(new Callback<SportResponse>() {
            @Override
            public void onResponse(Call<SportResponse> call, Response<SportResponse> response) {
                if (response.isSuccessful()){
                    mainView.onSucces(response.body().getTeams());
                } else {
                    mainView.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<SportResponse> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }
        });
    }
}
