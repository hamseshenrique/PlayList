package com.software.hms.playlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.software.hms.playlist.adapters.PlayListAdapter;
import com.software.hms.playlist.dto.Item;
import com.software.hms.playlist.dto.PlayListDto;
import com.software.hms.playlist.interfaces.PlayListAction;
import com.software.hms.playlist.interfaces.PlayListPresenter;
import com.software.hms.playlist.presenter.PlayListPresenterImpl;

import java.util.ArrayList;
import java.util.List;

public class PlayListActivity extends AppCompatActivity implements PlayListAction{

    private PlayListPresenter playListPresenter;
    private PlayListAdapter playListAdapter;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);

        playListPresenter = new PlayListPresenterImpl(this);
        playListPresenter.findPlayList();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        progressBar = (ProgressBar) findViewById(R.id.progress);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        playListAdapter = new PlayListAdapter(new ArrayList<Item>());
        recyclerView.setAdapter(playListAdapter);
    }

    @Override
    public void atualizar(final List<Item> items) {
        playListAdapter.add(items);
        playListAdapter.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }
}