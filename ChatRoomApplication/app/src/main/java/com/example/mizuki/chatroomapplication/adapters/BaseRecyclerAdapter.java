package com.example.mizuki.chatroomapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mizuki.chatroomapplication.data.vos.ChatVO;
import com.example.mizuki.chatroomapplication.viewholders.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<H extends BaseViewHolder,C> extends RecyclerView.Adapter<H>{
    protected List<C> mDataList;
    protected LayoutInflater layoutInflater;

    public BaseRecyclerAdapter(Context context) {
        layoutInflater = layoutInflater.from(context);
        mDataList = new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(@NonNull H h, int i) {
        if(mDataList.size()>0){
            h.setmData(mDataList.get(i));
            h.bind(layoutInflater.getContext());
        }

    }

    public void setmDataList(List<C> mDataList) {
        this.mDataList = mDataList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mDataList != null) {
            return mDataList.size();
        }else {
            return 0;
        }
    }
}