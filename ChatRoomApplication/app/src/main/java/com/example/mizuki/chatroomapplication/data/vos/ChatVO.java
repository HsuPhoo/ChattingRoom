
package com.example.mizuki.chatroomapplication.data.vos;

import java.util.List;

@SuppressWarnings("unused")
public class ChatVO {


    private List<ChatRoom> mChatRoom;

    public List<ChatRoom> getChatRoom() {
        return mChatRoom;
    }

    public void setChatRoom(List<ChatRoom> chatRoom) {
        mChatRoom = chatRoom;
    }

}
