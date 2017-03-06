package com.software.hms.playlist.dto;

import java.io.Serializable;

/**
 * Created by hms on 04/03/17.
 */
public class MediumDto implements Serializable{

    private String url;
    private Integer width;
    private Integer height;

    public MediumDto(){}


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
