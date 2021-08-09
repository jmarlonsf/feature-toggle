package com.deppit.feature.toggle.service.impl;

import com.deppit.feature.toggle.annotation.FeatureToggle;
import com.deppit.feature.toggle.model.Feature;
import com.deppit.feature.toggle.service.FeatureDataServices;
import com.deppit.feature.toggle.service.FeatureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeatureServiceImpl implements FeatureService {

    private final FeatureDataServices featureDataServices;

    public List<Feature> readMethods() {
        return new ArrayList<>(findAllFeatures())
                .stream()
                .map(method -> {
                    FeatureToggle annotation = method.getAnnotation(FeatureToggle.class);
                    log.info("Feature encontrada: >> {} <<", annotation.name());
                    return Feature.builder()
                            .name(annotation.name())
                            .build();
                }).collect(Collectors.toList());
    }

    @Override
    public List<Feature> refreshMethods() {

        Set<Feature> features = featureDataServices.loadData(new HashSet<>(readMethods()));

        return new ArrayList<>(features);
    }

    private Set<Method> findAllFeatures() {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forJavaClassPath()).setScanners(
                        new MethodAnnotationsScanner()));
        return reflections.getMethodsAnnotatedWith(FeatureToggle.class);
    }
}
