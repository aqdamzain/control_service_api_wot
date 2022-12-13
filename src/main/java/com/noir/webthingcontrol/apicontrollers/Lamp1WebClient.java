package com.noir.webthingcontrol.apicontrollers;

import com.noir.webthingcontrol.domains.OnProperty;
import com.noir.webthingcontrol.domains.WebThing;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class Lamp1WebClient {
    private final WebClient client;

    public Lamp1WebClient(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://192.168.1.203:80").build();
    }

    public Mono<WebThing> getThingDevice() {
        return this
                .client.get().uri("/things/lamp-1").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(WebThing.class);
    }

    public Mono<OnProperty> getPropertyOn() {
        return this
                .client.get().uri("/things/lamp-1/properties/on").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(OnProperty.class);
    }

    public Mono<OnProperty> updatePropertyOn(OnProperty onProperty) {
        return this
                .client.put().uri("/things/lamp-1/properties/on")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(onProperty), OnProperty.class)
                .retrieve()
                .bodyToMono(OnProperty.class);
    }
}
