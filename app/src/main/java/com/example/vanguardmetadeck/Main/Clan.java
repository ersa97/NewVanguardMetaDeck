package com.example.vanguardmetadeck.Main;

public class Clan {

    String name;
    String description;
    String photoUrl;

    public Clan(){

    }


    public Clan(String name, String description, String photoUrl) {
        this.name = name;
        this.description = description;
        this.photoUrl = photoUrl;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }





}
