package com.example.firedroid.firedroid.java_objects;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ServerValue;

import java.util.HashMap;

/**
 * Created by aguatno on 8/6/17.
 */
@IgnoreExtraProperties
public class User {
    private String currentLevel;
    private String emailAddress;
    private HashMap<String, Object> lastUpdate;
    private String name;
    private String photoUrl;
    private String rank;
    private int stars;

    public User() {
    }

    public User(String currentLevel, String name, String emailAddress, String rank, int stars, String photoUrl) {
        this.currentLevel = currentLevel;
        this.name = name;
        this.emailAddress = emailAddress;
        this.rank = rank;
        HashMap<String, Object> timestampNowObject = new HashMap<String, Object>();
        timestampNowObject.put("timestamp", ServerValue.TIMESTAMP);
        this.lastUpdate = timestampNowObject;
        this.stars = stars;
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getCurrentLevel() {
        return currentLevel;
    }

    public String getRank() {
        return rank;
    }

    public HashMap<String, Object> getLastUpdate()  {
        return lastUpdate;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Exclude
    public long getTimestampCreatedLong() {
        return (long) lastUpdate.get("timestamp");
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
