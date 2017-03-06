package com.software.hms.playlist.dto;

import java.io.Serializable;

/**
 * Created by hms on 04/03/17.
 */

public class ThumbnailsDto implements Serializable{

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
