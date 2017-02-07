package org.ua.service;

import java.util.List;

import org.ua.model.users.UserProfile;


public interface UserProfileService {

    UserProfile findById(int id);

    UserProfile findByType(String type);

    List<UserProfile> findAll();

}