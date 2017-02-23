package com.pzeszko.cleansound.service.user;

import com.pzeszko.cleansound.dto.UserDto;
import com.pzeszko.cleansound.exception.NotFoundException;
import com.pzeszko.cleansound.model.CurrentUser;
import com.pzeszko.cleansound.model.User;
import com.pzeszko.cleansound.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public User findUser(String email) {
        return userRepository.findOneByEmail(email).orElseThrow(NotFoundException::new);
    }

    @Override
    @Transactional()
    public User addUser(UserDto user) {
        return userRepository.save(mapper.map(user, User.class));
    }

    @Transactional
    @Override
    public void updateUser(UserDto user, User currentUser) {
        User userEntity = findUser(currentUser.getEmail());
        mapper.map(user, userEntity);
        userRepository.saveAndFlush(userEntity);
        updateSecurityContext(userEntity);
    }

    private void updateSecurityContext(User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CurrentUser userDetails = (CurrentUser) authentication.getPrincipal();
        userDetails.setUser(user);
    }
}


