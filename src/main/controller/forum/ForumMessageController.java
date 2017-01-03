package main.controller.forum;

import com.alibaba.fastjson.JSONObject;
import main.data.pojo.ForumMessage;
import main.data.serviceandimpl.services.IForumMessageService;
import main.data.serviceandimpl.servicesimpl.ForumMessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */

@Controller
public class ForumMessageController {

    @Autowired
    @Qualifier("forumMessageService")
    private IForumMessageService forumMessageService;

    @RequestMapping(value = "/forumpage", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String getForumPage(HttpServletRequest request) {
        String forumMessageList = forumMessageService.getJsonForumMessage(1);
        request.setAttribute("msgList", forumMessageList);
        return "ForumListPage";
    }

    @RequestMapping(value = "/forum", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getForumMessage(@RequestParam("index") int index) {
        return forumMessageService.getJsonForumMessage(index);
    }

    @RequestMapping(value="/oneforummsg/{userId}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String getForumMsgInfoPage(HttpServletRequest request) {

        return null;
    }
}
