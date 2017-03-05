package com.software.hms.playlist.dto;

/**
 * Created by hms on 04/03/17.
 */

public class ThumbnailsDto {

    private MediumDto medium;
    private HighDto high;

    public ThumbnailsDto(){}


    public MediumDto getMedium() {
        return medium;
    }

    public void setMedium(MediumDto medium) {
        this.medium = medium;
    }

    public HighDto getHigh() {
        return high;
    }

    public void setHigh(HighDto high) {
        this.high = high;
    }
}
