package com.deppit.feature.toggle.service;

import com.deppit.feature.toggle.model.Feature;

import java.util.List;

public interface FeatureDataServices {

    List<Feature> loadData(List<Feature> features);
}
