package com.example.consumingrestapi.entity;

public class Api {
    private String API;
    private String Description;
    private String Auth;
    private boolean HTTPS;
    private String Cors;
    private String Link;
    private String Category;

    public Api(String API, String description, String auth, boolean HTTPS, String cors, String link, String category) {
        this.API = API;
        Description = description;
        Auth = auth;
        this.HTTPS = HTTPS;
        Cors = cors;
        Link = link;
        Category = category;
    }

    public String getAPI() {
        return API;
    }

    public void setAPI(String API) {
        this.API = API;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAuth() {
        return Auth;
    }

    public void setAuth(String auth) {
        Auth = auth;
    }

    public boolean isHTTPS() {
        return HTTPS;
    }

    public void setHTTPS(boolean HTTPS) {
        this.HTTPS = HTTPS;
    }

    public String getCors() {
        return Cors;
    }

    public void setCors(String cors) {
        Cors = cors;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    @Override
    public String toString() {
        return "Api{" +
                "API='" + API + '\'' +
                ", Description='" + Description + '\'' +
                ", Auth='" + Auth + '\'' +
                ", HTTPS=" + HTTPS +
                ", Cors='" + Cors + '\'' +
                ", Link='" + Link + '\'' +
                ", Category='" + Category + '\'' +
                '}';
    }
}
