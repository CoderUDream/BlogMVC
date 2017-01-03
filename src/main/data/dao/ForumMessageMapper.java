package main.data.dao;

import main.data.pojo.ForumMessage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ForumMessage record);

    int insertSelective(ForumMessage record);

    ForumMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ForumMessage record);

    int updateByPrimaryKeyWithBLOBs(ForumMessage record);

    int updateByPrimaryKey(ForumMessage record);

    int getDataNums();

    List<ForumMessage> selectForumMessageByLimit(@Param("startIdx")int startIdx,@Param("offset") int offset);
}