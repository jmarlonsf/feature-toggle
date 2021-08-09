package com.deppit.feature.toggle.controller;

import com.deppit.feature.toggle.model.Feature;
import com.deppit.feature.toggle.service.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("feature-toggle")
@RequiredArgsConstructor
public class FeatureController {
    private final FeatureService service;

    @GetMapping
    public List<Feature> readAll(){
        return service.readMethods();
    }

    @GetMapping("/refresh")
    public List<Feature> refresh(){
        return service.refreshMethods();
    }
}
