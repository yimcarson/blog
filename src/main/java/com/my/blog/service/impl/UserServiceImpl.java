package com.my.blog.service.impl;

import com.my.blog.entity.Article;
import com.my.blog.entity.User;
import com.my.blog.repository.UserRepository;
import com.my.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User get(User record) {
        Example<User> example = Example.of(record);
        Optional<User> articleOptional = userRepository.findOne(example);
        return articleOptional.get();
    }
}
