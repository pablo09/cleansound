package com.pzeszko.cleansound.service;


import com.pzeszko.cleansound.dto.UserDto;
import com.pzeszko.cleansound.model.User;
import com.pzeszko.cleansound.service.user.UserService;
import lombok.AllArgsConstructor;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Pawel on 2017-01-31.
 */
@Transactional(readOnly = true)
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AccountServiceImpl implements AccountService {

    private final UserService userService;
    private final Mapper mapper;

    @Override
    public UserDto findUserData(String email) {
        return mapper.map(userService.findUser(email), UserDto.class);
    }

    @Override
    public void updateUserInfo(UserDto userDto, User user) {
        userService.updateUser(userDto, user);
    }
}
