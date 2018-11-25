package com.example.mizuki.chatroomapplication.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.example.mizuki.chatroomapplication.data.model.AppModel;
import com.example.mizuki.chatroomapplication.data.vos.ChatRoom;


public class AlertDialogBuilder {

    public static void showDialog(Context context, final AppModel appModel, final ChatRoom chatroom){
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle("Delete")
                .setMessage("Are you sure to delete this message?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        appModel.deleteChatMessage(chatroom);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        builder.create().show();
    }
}
