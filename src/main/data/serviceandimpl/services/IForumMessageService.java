package main.data.serviceandimpl.services;

import main.data.pojo.ForumMessage;

import java.util.List;

/**
 * Created by Administrator on 2016/12/7.
 */
public interface IForumMessageService {
    String getJsonForumMessage(int index);
    List<ForumMessage> getForumMessage(int index);
}
