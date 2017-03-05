package com.software.hms.playlist.enums;

/**
 * Created by hms on 05/03/17.
 */

public enum GoogleApiEnum {

    SERVER("https://www.googleapis.com"),
    PART("snippet"),
    CHANELID("UCVHFbqXqoYvEWM1Ddxl0QDg"),
    KEY("AIzaSyBPlVYsLeKqj9u7wjIQFzamljTaFKPVFSE");

    private String value;


    private GoogleApiEnum(final String value){
        this.value=value;
    }


    public String getValue() {
        return value;
    }
}
