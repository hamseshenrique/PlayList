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

public class PlayListItemAdapter extends RecyclerView.Adapter<PlayListItemHolder> {

    private List<Item> listItems;
    private Context context;

    public PlayListItemAdapter(final List<Item> listItems){
        this.listItems = listItems;
    }

    @Override
    public PlayListItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.play_list_item_layout,
                parent,false);
        context = layoutView.getContext();

        return new PlayListItemHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(PlayListItemHolder holder, int position) {
        final Item item = listItems.get(position);
        if(item.getSnippet() != null){
            final SnippetDto snippetDto = item.getSnippet();
            holder.getTextView().setText(snippetDto.getTitle());

            if(snippetDto.getThumbnails() != null){
                final ThumbnailsDto thumbnailsDto = snippetDto.getThumbnails();
                Picasso.with(context).load(thumbnailsDto.getMedium().getUrl())
                        .into(holder.getImageView());
            }
            //holder.onClickItem(item);
        }
    }

    public void add(final List<Item> listItems){
        this.listItems.addAll(listItems);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }
}
