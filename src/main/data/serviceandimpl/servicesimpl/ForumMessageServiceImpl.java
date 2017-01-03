package main.data.serviceandimpl.servicesimpl;

import com.alibaba.fastjson.JSONObject;
import main.data.dao.ForumMessageMapper;
import main.data.pojo.ForumMessage;
import main.data.serviceandimpl.services.IForumMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/12/7.
 */

@Service("forumMessageService")
public class ForumMessageServiceImpl implements IForumMessageService {
    private int iCount = 0;
    private static final int ONE_PAGE_NUMS = 3;

    @Resource
    ForumMessageMapper forumMessageMapper;

    public String getJsonForumMessage(int index) {
        JSONObject jsonObject = new JSONObject();
        if (index < 1) {
            jsonObject.put("resultData", "下标范围<1");
            jsonObject.put("result", "1");
            return jsonObject.toJSONString();
        }

        int nums = forumMessageMapper.getDataNums();
        if((index - 1) * ONE_PAGE_NUMS >= nums) {
            jsonObject.put("resultData", "该页签数量不存在");
            jsonObject.put("result", "1");
            return jsonObject.toJSONString();
        }

        System.out.println("iCount:" + iCount++);
        jsonObject.put("resultData", forumMessageMapper.selectForumMessageByLimit((index - 1) * ONE_PAGE_NUMS, ONE_PAGE_NUMS));
        jsonObject.put("result", "0");
        return jsonObject.toJSONString();
    }

    public List<ForumMessage> getForumMessage(int index) {
        if (index < 1) {
            return null;
        }

        int nums = forumMessageMapper.getDataNums();
        if(index * ONE_PAGE_NUMS > nums) {
            return null;
        }

        System.out.println("iCount:" + iCount++);
        return forumMessageMapper.selectForumMessageByLimit((index - 1) * ONE_PAGE_NUMS, ONE_PAGE_NUMS);
    }

}
