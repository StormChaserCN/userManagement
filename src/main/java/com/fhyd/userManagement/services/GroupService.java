package com.fhyd.userManagement.services;

import com.fhyd.userManagement.models.Group;
import com.fhyd.userManagement.models.User;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();

    void deleteGroup(Long id);

    void addGroup(Group g);

    Group getGroupById(Long id);

    void updateGroup(Group g);

    void addGroupUser(Long gid, Long uid);

    void delGroupUser(Long gid, Long uid);
}
