package com.deppit.feature.toggle.service;

import com.deppit.feature.toggle.model.Feature;

import java.util.Set;

public interface FeatureDataServices {

    Set<Feature> loadData(Set<Feature> features);
}
