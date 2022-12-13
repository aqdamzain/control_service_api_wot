package com.noir.webthingcontrol.services;

import com.noir.webthingcontrol.exception.GwInitException;
import com.noir.webthingcontrol.repository.GwRepository;
import com.noir.webthingcontrol.repository.GwRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GwService {

    @Autowired
    GwRepository gwRepository;

    public Void init(String rfid, String name, String host, String apiLink, String gatewayId) throws GwInitException {
        Integer count = gwRepository.getCountByRfid(rfid);
        if(count > 0) {
            gwRepository.updateByRfid(rfid, name, host, apiLink, gatewayId);
        } else {
            gwRepository.create(rfid, name, host, apiLink, gatewayId);
        }
        return null;
    }
}
