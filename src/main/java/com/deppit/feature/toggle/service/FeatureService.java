package com.deppit.feature.toggle.service;

import com.deppit.feature.toggle.model.Feature;

import java.util.List;

public interface FeatureService {

    List<Feature> readMethods();

    List<Feature> refreshMethods();
}
