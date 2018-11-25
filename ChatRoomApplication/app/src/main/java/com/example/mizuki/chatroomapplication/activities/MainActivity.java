package com.example.mizuki.chatroomapplication.activities;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mizuki.chatroomapplication.R;
import com.example.mizuki.chatroomapplication.adapters.ChatRecyclerAdapter;
import com.example.mizuki.chatroomapplication.data.vos.ChatRoom;
import com.example.mizuki.chatroomapplication.delegate.ChatDeleteCallback;
import com.example.mizuki.chatroomapplication.delegate.ChatListCallBack;
import com.example.mizuki.chatroomapplication.utils.AlertDialogBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements ChatDeleteCallback{
    @BindView(R.id.rv_chat_room)
    RecyclerView rvChatRoom;
    @BindView(R.id.et_message)
    EditText etMessage;
    @BindView(R.id.btn_send)
    Button btnSend;
    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressBar.setVisibility(View.VISIBLE);
        getmAppModel().startLoadingChatList(new ChatListCallBack() {
            @Override
            public void loadChatList(List<ChatRoom> chatRoomList) {
                setupRecyclerView(chatRoomList);
                //Toast.makeText(MainActivity.this,"Size is "+chatRoomList.size(),Toast.LENGTH_SHORT).show();
                showNotification();
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    @OnClick(R.id.btn_send)
    public void onTabButton(){
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setMessage(etMessage.getText().toString());
        etMessage.setText("");
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        chatRoom.setDate(strDate);
        chatRoom.setCreatetime(String.valueOf(new Date().getTime()));
        chatRoom.setDelete(Long.valueOf(0));
        getmAppModel().startUploadChatMessage(chatRoom);
    }

    private void setupRecyclerView(List<ChatRoom> chatList) {

       ChatRecyclerAdapter chatRecyclerAdapter = new ChatRecyclerAdapter(this, this);
        rvChatRoom.setLayoutManager(new LinearLayoutManager(this));
        rvChatRoom.setAdapter(chatRecyclerAdapter);
        chatRecyclerAdapter.setmDataList(chatList);

    }


    @Override
    protected boolean setDisplayHomeEnabled() {
        return false;

    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void deleteChat(ChatRoom chatRoom) {
        AlertDialogBuilder.showDialog(this,getmAppModel(),chatRoom);
    }

    private void showNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Notification")
                .setContentText("Not Good");

        //to go app when press noti
        Intent intent = new Intent(MainActivity.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,7,intent,0);
        //tell builder pending
        builder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(7,builder.build());
    }
}
