package org.ua.dao;

import java.util.List;

import org.ua.model.users.UserProfile;


public interface UserProfileDao {

    List<UserProfile> findAll();

    UserProfile findByType(String type);

    UserProfile findById(int id);
}