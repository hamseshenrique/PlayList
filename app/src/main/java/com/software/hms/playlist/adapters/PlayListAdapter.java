package com.software.hms.playlist.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.software.hms.playlist.R;
import com.software.hms.playlist.dto.Item;
import com.software.hms.playlist.dto.SnippetDto;
import com.software.hms.playlist.dto.ThumbnailsDto;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by hms on 05/03/17.
 */

public class PlayListAdapter extends RecyclerView.Adapter<PlayListHolder>{

    private List<Item> listItems;
    private Context context;

    public PlayListAdapter(final List<Item> listItems){
        this.listItems = listItems;
    }

    @Override
    public PlayListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.play_list_layout, parent,false);
        context = layoutView.getContext();
        return new PlayListHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(PlayListHolder holder, int position) {
        final Item item = listItems.get(position);
        if(item.getSnippet() != null){
            final SnippetDto snippetDto = item.getSnippet();
            holder.getChannelTitle().setText(snippetDto.getChannelTitle());
            holder.getTitle().setText(snippetDto.getTitle());

            if(snippetDto.getThumbnails() != null){
                final ThumbnailsDto thumbnailsDto = snippetDto.getThumbnails();
                Picasso.with(context).load(thumbnailsDto.getHigh().getUrl())
                       .into(holder.getImageView());
            }
        }
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public void add(final List<Item> listItems){
        this.listItems.addAll(listItems);
    }
}
