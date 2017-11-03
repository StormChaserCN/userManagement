package com.fhyd.userManagement.services;

import com.fhyd.userManagement.models.Group;
import com.fhyd.userManagement.models.User;
import com.fhyd.userManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        User u = userRepository.findOne(id);
        for(Group group : u.getGroupSet())
        {
            group.getUserSet().remove(u);
        }
        userRepository.delete(id);
        return;
    }

    @Override
    public void addUser(User u) {
        userRepository.save(u);
        return;
    }

    @Override
    public void updateUser(User u) {
        userRepository.save(u);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }
}
