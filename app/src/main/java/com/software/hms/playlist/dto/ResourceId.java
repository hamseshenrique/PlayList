package com.software.hms.playlist.dto;

import java.io.Serializable;

/**
 * Created by hms on 06/03/17.
 */

public class ResourceId implements Serializable{

    private String videoId;

    public ResourceId(){}


    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
