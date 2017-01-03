package main.data.pojo;

import java.util.Date;

public class ForumMessage {
    private Integer id;

    private Integer userId;

    private Date publishTime;

    private String descWord;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getDescWord() {
        return descWord;
    }

    public void setDescWord(String descWord) {
        this.descWord = descWord == null ? null : descWord.trim();
    }
}