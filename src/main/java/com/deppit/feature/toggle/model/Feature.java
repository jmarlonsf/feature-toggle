package com.deppit.feature.toggle.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Feature {

    private String id;
    private boolean enable;
}
