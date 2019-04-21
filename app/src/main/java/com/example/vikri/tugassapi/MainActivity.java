package com.example.vikri.tugassapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.vikri.tugassapi.Adapter.ArtikelAdapter;
import com.example.vikri.tugassapi.Model.TeamsItem;
import com.example.vikri.tugassapi.Presenter.MainPresenter;
import com.example.vikri.tugassapi.Presenter.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {
    private RecyclerView A;
    private ArtikelAdapter adapter;
    private MainPresenter mainPresenter;
    private String API_KEY = "4013072";
  //  private String source = "s=Soccer&c=Spain";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        A = findViewById(R.id.rec_artikel);
        mainPresenter = new MainPresenter(this, this);
       mainPresenter.loadArtikel(API_KEY);
    }

    @Override
    public void onSucces(List<TeamsItem> articlesItemList) {
        adapter = new ArtikelAdapter(getApplicationContext(), articlesItemList);
        A.setLayoutManager(new LinearLayoutManager(this));
        A.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(this, failureMessage, Toast.LENGTH_SHORT).show();
    }
}
