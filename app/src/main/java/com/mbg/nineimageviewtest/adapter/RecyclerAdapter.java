package com.mbg.nineimageviewtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mbg.nineimageview.NineImageView;
import com.mbg.nineimageviewtest.R;
import com.mbg.nineimageviewtest.bean.Dynamic;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/21.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<Dynamic> dynamicList;
    private Context mContext;
    private NineImageView.onBindScrollSpeedListener listener;
    private boolean isScrolling=false;
    public RecyclerAdapter(Context context,List list){
        if(list == null){
            dynamicList=new ArrayList<>();
        }else {
            this.dynamicList = list;
        }
        this.mContext=context;
        listener=new NineImageView.onBindScrollSpeedListener() {
            @Override
            public boolean isScrolling() {
                return isScrolling;
            }
        };
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_layout,parent,false),listener);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.bindValue(dynamicList.get(position),position);
        Picasso.with(mContext).load(dynamicList.get(position).getUser().headIconUrl).into(holder.headIcon);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        //super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == RecyclerView.SCROLL_STATE_SETTLING){
                    isScrolling=true;
                }
                else if(newState == RecyclerView.SCROLL_STATE_DRAGGING){
                    isScrolling=false;
                }
                else{
                    isScrolling=false;
                    notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dynamicList.size();
    }

}


