package com.example.mvp;

import java.util.List;

public class FeatureCollection {

    private String type;
    private Metadata metadata;
    private List<Feature> features;

    public String getType() {
        return type;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public List<Feature> getFeatures() {
        return features;
    }
}
