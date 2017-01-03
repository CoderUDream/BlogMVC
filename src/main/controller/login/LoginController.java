package main.controller.login;

import main.data.serviceandimpl.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/12/7.
 */

@Controller
public class LoginController {
    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @RequestMapping(value = "/")//, method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String login(@RequestParam("username")String username, @RequestParam("password")String password) {
        return userService.login(username, password);
    }

    @RequestMapping(value = "/forumPage", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String getForumPage() {
        return "ForumListPage";
    }
}
