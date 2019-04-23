package com.kewail.project.mailbox.mail.mapper;

import com.kewail.project.mailbox.mail.domain.GroupMail;

public interface GroupMailMapper {
    int deleteByPrimaryKey(Integer taskId);

    int insert(GroupMail record);

    int insertSelective(GroupMail record);

    GroupMail selectByPrimaryKey(Integer taskId);

    int updateByPrimaryKeySelective(GroupMail record);

    int updateByPrimaryKey(GroupMail record);
}