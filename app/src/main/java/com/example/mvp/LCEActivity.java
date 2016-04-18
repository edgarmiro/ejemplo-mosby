package com.example.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LCEActivity extends MvpLceViewStateActivity<SwipeRefreshLayout, List<Feature>,
        EarthquakesView, EarthquakesPresenter>
        implements EarthquakesView, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private EarthquakesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lce);
        ButterKnife.bind(this);
        setRetainInstance(true);

        contentView.setOnRefreshListener(this);

        // Setup recycler view
        adapter = new EarthquakesAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        loadData(false);
    }

    @NonNull
    @Override
    public EarthquakesPresenter createPresenter() {
        return new EarthquakesPresenter();
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return "ERROR: " + e;
    }

    @Override
    public void setData(List<Feature> data) {
        adapter.setEarthquakes(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        String startTime = Util.currentDateMinusDays(30);
        String endTime = Util.currentDate();
        presenter.loadEarthquakes(pullToRefresh, startTime, endTime);
    }

    @Override
    public void onRefresh() {
        loadData(true);
    }

    @Override
    public void showContent() {
        super.showContent();
        contentView.setRefreshing(false);
    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        super.showError(e, pullToRefresh);
        contentView.setRefreshing(false);
    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        super.showLoading(pullToRefresh);
        contentView.setRefreshing(pullToRefresh);
    }

    @NonNull
    @Override
    public LceViewState<List<Feature>, EarthquakesView> createViewState() {
        return new RetainingLceViewState<>();
    }

    @Override
    public List<Feature> getData() {
        return adapter == null ? null : adapter.getEarthquakes();
    }
}
