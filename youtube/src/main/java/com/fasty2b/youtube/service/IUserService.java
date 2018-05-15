package com.fasty2b.youtube.service;

import java.util.List;

import com.fasty2b.youtube.entity.User;

public interface IUserService {
     List<User> getAllUsers();
     User getUserByUserId(String userId);
     boolean addUser(User user);
     void updateUser(User user);
     void deleteUser(String userId);
     boolean checkUser(User user);
}
