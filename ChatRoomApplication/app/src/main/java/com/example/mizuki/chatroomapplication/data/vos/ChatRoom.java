
package com.example.mizuki.chatroomapplication.data.vos;

@SuppressWarnings("unused")
public class ChatRoom {

    private  String createtime;

    private String date;

    private Long delete;

    private String message;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getDelete() {
        return delete;
    }

    public void setDelete(Long delete) {
        this.delete = delete;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
