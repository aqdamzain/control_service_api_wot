package com.noir.webthingcontrol.apicontrollers;

import com.noir.webthingcontrol.domains.GatewayInit;
import com.noir.webthingcontrol.domains.OnProperty;
import com.noir.webthingcontrol.domains.WebThing;
import com.noir.webthingcontrol.utils.ObjConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/control-1/lamp-1")
public class Lamp1APIController {

    @Autowired
    Lamp1WebClient lamp1WebClient;

    @GetMapping
    public ResponseEntity<Mono<WebThing>> getThingDevice(){
        return new ResponseEntity<>(lamp1WebClient.getThingDevice(), HttpStatus.OK);
    }

    @GetMapping("/properties/on")
    public ResponseEntity<Mono<OnProperty>> getPropertyOn(){
        return new ResponseEntity<>(lamp1WebClient.getPropertyOn(), HttpStatus.OK);
    }

    @PutMapping("/properties/on")
    public ResponseEntity<Mono<OnProperty>> updatePropertyOn(@RequestBody OnProperty onProperty){
        return new ResponseEntity<>(lamp1WebClient.updatePropertyOn(onProperty), HttpStatus.OK);
    }

}
