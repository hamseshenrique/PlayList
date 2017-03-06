package com.software.hms.playlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.software.hms.playlist.adapters.PlayListItemAdapter;
import com.software.hms.playlist.dto.Item;
import com.software.hms.playlist.interfaces.PlayListAction;
import com.software.hms.playlist.interfaces.PlayListPresenter;
import com.software.hms.playlist.presenter.PlayListPresenterImpl;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PlayListItemActivity extends AppCompatActivity implements PlayListAction{

    private PlayListPresenter playListPresenter;
    private PlayListItemAdapter playListItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list_item);

        playListPresenter = new PlayListPresenterImpl(this);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){

            final Item item = (Item) bundle.getSerializable("item");
            final ImageView imageView = (ImageView) findViewById(R.id.imgItem);
            final String url = item.getSnippet().getThumbnails().getHigh().getUrl();
            Picasso.with(this).load(url).into(imageView);

            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            playListItemAdapter = new PlayListItemAdapter(new ArrayList<Item>());
            recyclerView.setAdapter(playListItemAdapter);

            playListPresenter.findByIdPlayList(item.getId());
        }
    }

    @Override
    public void atualizar(List<Item> items) {
        playListItemAdapter.add(items);
        playListItemAdapter.notifyDataSetChanged();
    }
}
