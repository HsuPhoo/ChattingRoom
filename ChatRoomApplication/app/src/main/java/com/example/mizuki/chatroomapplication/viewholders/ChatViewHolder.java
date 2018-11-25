package com.example.mizuki.chatroomapplication.viewholders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.mizuki.chatroomapplication.R;
import com.example.mizuki.chatroomapplication.data.vos.ChatRoom;
import com.example.mizuki.chatroomapplication.delegate.ChatDeleteCallback;

import org.w3c.dom.Text;

import butterknife.BindView;

public class ChatViewHolder extends BaseViewHolder<ChatRoom>  implements View.OnLongClickListener{
    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.tv_date)
    TextView tvDate;

    ChatDeleteCallback mChatDeleteCallback;

    public ChatViewHolder(@NonNull View itemView, ChatDeleteCallback chatDeleteCallback) {
        super(itemView);
        itemView.setOnLongClickListener(this);
        mChatDeleteCallback = chatDeleteCallback;
    }

    @Override
    public void bind(Context context) {
        tvMessage.setText(mData.getMessage());
        tvDate.setText(mData.getDate());
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onLongClick(View v) {
        mChatDeleteCallback.deleteChat(mData);
        return true;
    }
}
