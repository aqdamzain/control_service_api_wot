package com.noir.webthingcontrol.domains;

public class Thing {
    private String id;
    private String title;
    private String[] type;
    private String web_id;

    public Thing(String id, String title, String[] type, String web_id) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.web_id = web_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public String getWeb_id() {
        return web_id;
    }

    public void setWeb_id(String web_id) {
        this.web_id = web_id;
    }
}
