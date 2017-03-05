package com.software.hms.playlist.dto;

/**
 * Created by hms on 04/03/17.
 */
public class LocalizedDto {

    private String title;
    private String description;

    public LocalizedDto(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
