package com.pzeszko.cleansound.service;

import com.pzeszko.cleansound.dto.UserDto;
import com.pzeszko.cleansound.model.User;

/**
 * Created by Pawel on 2017-01-03.
 */
public interface AccountService {

    UserDto findUserData(String email);

    void updateUserInfo(UserDto userDto, User currentUser);
}
