package main.data.serviceandimpl.services;

import main.data.pojo.User;

/**
 * Created by Administrator on 2016/12/7.
 */
public interface IUserService {
    public String login(String userName, String password);

    //public User selectByUserName(String userName);
}
