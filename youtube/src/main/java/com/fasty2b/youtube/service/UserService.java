package com.fasty2b.youtube.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasty2b.youtube.dao.UserRepository;
import com.fasty2b.youtube.entity.User;
@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User getUserByUserId(String userId) {
		User obj = userRepository.findByUserId(userId);
		return obj;
	}	
	@Override
	public List<User> getAllUsers(){
		List<User> list = new ArrayList<>();
		userRepository.findAll().forEach(e -> list.add(e));
		return list;
	}
	@Override
	public synchronized boolean addUser(User user){
	   List<User> list = userRepository.findByUserIdAndUserPass(user.getUserId(), user.getUserPass()); 	
       if (list.size() > 0) {
    	   return false;
       } else {
    	   userRepository.save(user);
    	   return true;
       }
	}
	@Override
	public void updateUser(User article) {
		userRepository.save(article);
	}
	@Override
	public void deleteUser(String userId) {
		userRepository.delete(getUserByUserId(userId));
	}
	@Override
	public boolean checkUser(User user) {
		String userId = user.getUserId();
		User userDb = getUserByUserId(userId);
		if(userDb != null) {
			if(StringUtils.equals(userDb.getUserPass(), user.getUserPass())) {
				return true;
			}
		}
		return false;
	}
}
