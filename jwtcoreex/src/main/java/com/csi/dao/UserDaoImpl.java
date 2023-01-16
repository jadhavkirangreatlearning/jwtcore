package com.csi.dao;

import com.csi.model.User;
import com.csi.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl {

    @Autowired
    UserRepo userRepoImpl;

    public User saveData(User user){
        return userRepoImpl.save(user);
    }

    public List<User> getAllDatta(){
        return userRepoImpl.findAll();
    }

    public User updateData(User user){
        return userRepoImpl.save(user);
    }

    public void deleteData(int userId){
        userRepoImpl.deleteById(userId);
    }

    public User findByUserName(String userName){
        return userRepoImpl.findByUserName(userName);
    }
}
