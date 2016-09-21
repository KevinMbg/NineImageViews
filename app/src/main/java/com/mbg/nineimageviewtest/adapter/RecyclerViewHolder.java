package com.mbg.nineimageviewtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mbg.nineimageview.NineGridView;
import com.mbg.nineimageview.NineGridViewAdapter;
import com.mbg.nineimageviewtest.R;
import com.mbg.nineimageviewtest.bean.Dynamic;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder{
    public ImageView headIcon;
    private TextView nickName;
    private TextView content;
    private NineGridView image9View;

    private NineGridViewAdapter adapter=new NineGridViewAdapter<String>() {
        @Override
        protected void onDisplayImage(Context context, final ImageView imageView, String url) {
            Picasso.with(context)
                    .load(url)
                    .into(imageView);
        }

        @Override
        protected void onItemImageClick(Context context, int index, List<String> list) {
            super.onItemImageClick(context, index, list);
            Toast.makeText(context,"当前位置："+index+","+list.get(index),Toast.LENGTH_SHORT).show();
        }
    };

    public RecyclerViewHolder(View itemView, NineGridView.onBindScrollSpeedListener listener) {
        super(itemView);
        headIcon=(ImageView)itemView.findViewById(R.id.headIv);
        nickName=(TextView)itemView.findViewById(R.id.nameTv);
        content=(TextView)itemView.findViewById(R.id.contentTv);
        image9View=(NineGridView)itemView.findViewById(R.id.image9view);
        image9View.setAdapter(adapter);
        image9View.setOnBindScrllListener(listener);

    }

    public void bindValue(Dynamic dynamic, int position){
        nickName.setText(dynamic.getUser().nickName+","+position);
        content.setText(dynamic.getContent());
        image9View.setImagesData(dynamic.getPhotos());
    }
}
