package com.example.mizuki.chatroomapplication.viewholders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseViewHolder<C> extends RecyclerView.ViewHolder implements View.OnClickListener {

    protected C mData;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(this);
    }

    public void setmData(C mData) {
        this.mData = mData;
    }

    public abstract void bind(Context context);

}
