package com.csi.service;

import com.csi.dao.UserDaoImpl;
import com.csi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl  implements UserDetailsService {

    @Autowired
    UserDaoImpl userDaoImpl;

    public User saveData(User user){
        return userDaoImpl.saveData(user);
    }

    public List<User> getAllDatta(){
        return userDaoImpl.getAllDatta();
    }

    public User updateData(User user){
        return userDaoImpl.updateData(user);
    }

    public void deleteData(int userId){
        userDaoImpl.deleteData(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDaoImpl.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(), new ArrayList<>());
    }
}
