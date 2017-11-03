package com.fhyd.userManagement.services;

import com.fhyd.userManagement.models.Group;
import com.fhyd.userManagement.models.User;
import com.fhyd.userManagement.repository.GroupRepository;
import com.fhyd.userManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public void deleteGroup(Long id) {
        Group g = groupRepository.findOne(id);
        g.setUserSet(null);
        groupRepository.delete(id);
    }

    @Override
    public void addGroup(Group g) {
        groupRepository.save(g);
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.getOne(id);
    }

    @Override
    public void updateGroup(Group g) {
        groupRepository.save(g);
    }

    @Override
    public void addGroupUser(Long gid, Long uid) {
        Group g = groupRepository.findOne(gid);
        g.getUserSet().add(userRepository.findOne(uid));
        groupRepository.save(g);
    }

    @Override
    public void delGroupUser(Long gid, Long uid) {
        Group g = groupRepository.findOne(gid);
        g.getUserSet().remove(userRepository.findOne(uid));
        groupRepository.save(g);
    }


}
