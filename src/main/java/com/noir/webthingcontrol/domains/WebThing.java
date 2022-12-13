package com.noir.webthingcontrol.domains;


import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.noir.webthingcontrol.utils.RawJsonDeserializer;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebThing {
    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("base")
    private String base;
    @JsonProperty("@type")
    private String[] type;
    @JsonProperty("links")
    private WebThingLink[] links;


    @JsonProperty("properties")
    @JsonDeserialize(using = RawJsonDeserializer.class)
    private String properties;
}
