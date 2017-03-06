package com.software.hms.playlist.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.software.hms.playlist.PlayListItemActivity;
import com.software.hms.playlist.R;
import com.software.hms.playlist.dto.Item;

/**
 * Created by hms on 05/03/17.
 */

public class PlayListHolder extends RecyclerView.ViewHolder{

    private ImageView imageView;
    private TextView channelTitle;
    private TextView title;
    private View itemView;

    public PlayListHolder(View itemView) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.img);
        channelTitle = (TextView) itemView.findViewById(R.id.channelTitle);
        title = (TextView) itemView.findViewById(R.id.title);
        this.itemView = itemView;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void onClickItem(final Item item){
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(view.getContext(), PlayListItemActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("item",item);
                intent.putExtras(bundle);

                view.getContext().startActivity(intent);
            }
        });
    }

    public TextView getChannelTitle() {
        return channelTitle;
    }

    public TextView getTitle() {
        return title;
    }
}
