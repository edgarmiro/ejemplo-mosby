package com.example.mvp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EarthquakesAdapter extends RecyclerView.Adapter<EarthquakesAdapter.ViewHolder> {

    private final List<Feature> mList;

    public EarthquakesAdapter() {
        super();
        this.mList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_earthquake, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Feature feature = getItem(position);
        holder.textView.setText(feature.getProperties().getTitle());
        holder.textViewDate.setText(Util.parseDate(feature.getProperties().getTime()));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public Feature getItem(int position) {
        return mList.get(position);
    }

    public void setEarthquakes(List<Feature> list) {
        this.mList.clear();
        this.mList.addAll(list);
    }

    public List<Feature> getEarthquakes() {
        return mList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textView;
        public final TextView textViewDate;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            textViewDate = (TextView) itemView.findViewById(R.id.textViewDate);
        }
    }
}
