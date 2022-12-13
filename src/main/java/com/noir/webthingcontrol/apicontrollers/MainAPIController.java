package com.noir.webthingcontrol.apicontrollers;

import com.noir.webthingcontrol.domains.GatewayInit;
import com.noir.webthingcontrol.utils.Constants;
import com.noir.webthingcontrol.utils.ObjConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/api")
public class MainAPIController {

    @GetMapping
    public ResponseEntity<Map<String, String>> getToken(){
        return new ResponseEntity<>(generateJWTToken(ObjConstants.getGW()), HttpStatus.OK);
    }

    @GetMapping("/control-1")
    public ResponseEntity<GatewayInit> getAllWebthing(HttpServletRequest request) {
        return new ResponseEntity<>(ObjConstants.getGW(), HttpStatus.OK);
    }

    private Map<String, String> generateJWTToken(GatewayInit gatewayInit) {
        long timestamp = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
                .claim("rfid", gatewayInit.getRfid())
                .compact();
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;
    }
}