package com.lanou.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lanou.bean.Message;

@Repository
public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKeyWithBLOBs(Message record);

    int updateByPrimaryKey(Message record);
    
    List<Message> serlectAllmessage();
}