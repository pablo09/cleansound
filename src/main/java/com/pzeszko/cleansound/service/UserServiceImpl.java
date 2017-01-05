package com.pzeszko.cleansound.service;

import com.pzeszko.cleansound.dto.UserDto;
import com.pzeszko.cleansound.model.User;
import com.pzeszko.cleansound.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pawel on 2017-01-03.
 */
@Transactional(readOnly = true)
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Mapper mapper;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional()
    public User addUser(UserDto user) {
        return userRepository.save(mapper.map(user, User.class));
    }
}


