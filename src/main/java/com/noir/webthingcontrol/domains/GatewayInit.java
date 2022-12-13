package com.noir.webthingcontrol.domains;

import java.util.List;

public class GatewayInit {
    private String rfid;
    private String name;
    private String host;
    private String apiLink;
    private String gatewayId;
    private List<Thing> things;

    public GatewayInit(String rfid, String name, String host, String apiLink, String gatewayId, List<Thing> things) {
        this.rfid = rfid;
        this.name = name;
        this.host = host;
        this.apiLink = apiLink;
        this.gatewayId = gatewayId;
        this.things = things;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getApiLink() {
        return apiLink;
    }

    public void setApiLink(String apiLink) {
        this.apiLink = apiLink;
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public List<Thing> getThings() {
        return things;
    }

    public void setThings(List<Thing> things) {
        this.things = things;
    }
}
