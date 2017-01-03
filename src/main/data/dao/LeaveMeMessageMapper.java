package main.data.dao;

import main.data.pojo.LeaveMeMessage;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveMeMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LeaveMeMessage record);

    int insertSelective(LeaveMeMessage record);

    LeaveMeMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LeaveMeMessage record);

    int updateByPrimaryKey(LeaveMeMessage record);
}