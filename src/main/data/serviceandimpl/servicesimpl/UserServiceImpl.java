package main.data.serviceandimpl.servicesimpl;

import com.alibaba.fastjson.JSONObject;
import main.data.dao.UserMapper;
import main.data.pojo.User;
import main.data.serviceandimpl.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/12/7.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    public String login(String userName, String password) {
        if(userName.length() == 0 || password.length() == 0) {
            return JSONObject.toJSONString("LoginFailed");
        }

        User user = userMapper.selectByUserName(userName);
        if (user.getId() != null) {
            if (password.compareTo(user.getPassword()) == 0) {
                return JSONObject.toJSONString(user);
            }
        }

        return JSONObject.toJSONString("LoginFailed");
    }
}
