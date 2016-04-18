package com.example.mvp;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import java.util.List;

// View interface
interface EarthquakesView extends MvpLceView<List<Feature>> {
    // MvpLceView already defines LCE methods:
    //
    // void showLoading(boolean pullToRefresh)
    // void showError(Throwable t, boolean pullToRefresh)
    // void setData(List<Country> data)
    // void showContent()
}
