package com.noir.webthingcontrol.repository;

import com.noir.webthingcontrol.exception.GwInitException;

public interface GwRepository {
    Integer create(String rfid, String name, String host, String apiLink, String gatewayId) throws GwInitException;

    Integer getCountByRfid(String rfid);

    Integer updateByRfid(String rfid, String name, String host, String apiLink, String gatewayId) throws GwInitException;
}
