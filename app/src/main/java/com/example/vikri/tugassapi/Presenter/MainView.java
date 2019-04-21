package com.example.vikri.tugassapi.Presenter;

import com.example.vikri.tugassapi.Model.TeamsItem;

import java.util.List;

public interface MainView {
    void onSucces(List<TeamsItem> articlesItemList);

    void onError(String errorMessage);

    void onFailure(String failureMessage);
}
