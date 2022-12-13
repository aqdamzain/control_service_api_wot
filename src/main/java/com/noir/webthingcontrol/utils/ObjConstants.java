package com.noir.webthingcontrol.utils;

import com.noir.webthingcontrol.domains.GatewayInit;
import com.noir.webthingcontrol.domains.Thing;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class ObjConstants {
    public static final String thingRfId = "04 2C 38 7A F8 51 80";

    public static final Thing[] things = {
            new Thing(thingRfId, "DC Lamp", new String[] {"OnOffSwitch", "Lamp"}, "lamp-1"),
            new Thing(thingRfId, "DC Fan", new String[] {"OnOffSwitch", "Fan"}, "fan-1")};

    public static GatewayInit getGW(){
        GatewayInit gatewayInit = null;
            try {
                gatewayInit = new GatewayInit(
                        thingRfId, "WebThings Control Gateway", "http://"+InetAddress.getLocalHost().getHostAddress()+":8081",
                        "/api/control-1", "control-1",
                        List.of(things)
                );
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        return gatewayInit;
    }
}
