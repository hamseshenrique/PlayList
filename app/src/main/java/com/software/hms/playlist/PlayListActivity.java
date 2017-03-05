package com.software.hms.playlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.software.hms.playlist.dto.PlayListDto;
import com.software.hms.playlist.interfaces.PlayListAction;
import com.software.hms.playlist.interfaces.PlayListPresenter;
import com.software.hms.playlist.presenter.PlayListPresenterImpl;

import java.util.List;

public class PlayListActivity extends AppCompatActivity implements PlayListAction{

    private PlayListPresenter playListPresenter;
    private TextView teste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);

        teste = (TextView) findViewById(R.id.teste);
        playListPresenter = new PlayListPresenterImpl(this);
        playListPresenter.findPlayList();

    }

    @Override
    public void atualizar(final List<PlayListDto> playListDtos) {

    }
}