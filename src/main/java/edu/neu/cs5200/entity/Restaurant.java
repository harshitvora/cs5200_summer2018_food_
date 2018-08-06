package edu.neu.cs5200.entity;

public class Restaurant {
    private int id;
    private String name;
    private String url;
    private String email;

    public Restaurant(int id, String name, String url, String email) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
