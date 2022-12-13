package com.noir.webthingcontrol.repository;

import com.noir.webthingcontrol.exception.GwInitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class GwRepositoryImpl implements GwRepository {

    private static final String SQL_CREATE = "INSERT INTO TB_GATEWAYS" +
            "(DEVICE_ID, RFID, NAME, HOST, API_LINK, GATEWAY_ID) " +
            "VALUES(NEXTVAL('TB_DEVICES_SEQ'), ?, ?, ?, ?, ?)";

    private static final String SQL_COUNT_BY_RFID = "SELECT COUNT(*) FROM " +
            "TB_GATEWAYS WHERE RFID = ?";

    private static final String SQL_UPDATE_BY_RFID = "UPDATE TB_GATEWAYS SET " +
            "NAME = ?, HOST = ?, API_LINK = ?, GATEWAY_ID = ? " +
            "WHERE RFID = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer create(String rfid, String name, String host, String apiLink, String gatewayId) throws GwInitException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection
                        .prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, rfid);
                ps.setString(2, name);
                ps.setString(3, host);
                ps.setString(4, apiLink);
                ps.setString(5, gatewayId);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("DEVICE_ID");
        }catch (Exception e) {
            throw new GwInitException("Invalid details. Failed to init gateway");
        }
    }

    @Override
    public Integer getCountByRfid(String rfid) {
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_RFID, new Object[]{rfid}, Integer.class);
    }

    @Override
    public Integer updateByRfid(String rfid, String name, String host, String apiLink, String gatewayId) throws GwInitException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection
                        .prepareStatement(SQL_UPDATE_BY_RFID, Statement.RETURN_GENERATED_KEYS);

                ps.setString(1, name);
                ps.setString(2, host);
                ps.setString(3, apiLink);
                ps.setString(4, gatewayId);
                ps.setString(5, rfid);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("DEVICE_ID");
        }catch (Exception e) {
            throw new GwInitException("Invalid details. Failed to init gateway");
        }
    }
}
