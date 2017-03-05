package com.software.hms.playlist.interfaces;

import com.software.hms.playlist.dto.PlayListDto;

import java.util.List;

/**
 * Created by hms on 04/03/17.
 */
public interface PlayListAction {

    void atualizar(final List<PlayListDto> playListDtos);
}
