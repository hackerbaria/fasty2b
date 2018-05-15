package com.fasty2b.youtube.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fasty2b.youtube.entity.User;



public interface UserRepository extends CrudRepository<User, Long>  {
    User findByUserId(String userId);    
    List<User> findByUserIdAndUserPass(String title, String category);
}
