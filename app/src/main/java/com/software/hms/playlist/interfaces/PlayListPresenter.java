package com.software.hms.playlist.interfaces;


/**
 * Created by hms on 04/03/17.
 */
public interface PlayListPresenter {
    /**
     *
     */
    void findPlayList();

    /**
     *
     * @param playListId
     */
    void findByIdPlayList(final String playListId);
}
