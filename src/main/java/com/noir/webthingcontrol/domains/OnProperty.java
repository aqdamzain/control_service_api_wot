package com.noir.webthingcontrol.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OnProperty {
    @JsonProperty("on")
    private boolean id;
}
