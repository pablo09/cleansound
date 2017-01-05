package com.pzeszko.cleansound.service;

import com.pzeszko.cleansound.dto.UserDto;
import com.pzeszko.cleansound.model.User;

import java.util.List;

/**
 * Created by Pawel on 2017-01-03.
 */
public interface UserService {

    List<User> findAll();

    User addUser(UserDto user);
}
