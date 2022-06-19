package com.frugalis.jasypt.service;

import com.frugalis.jasypt.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    Users save(Users users);

    Users update(Users users);

    Optional<Users> partialUpdate(Users users);

    List<Users> findAll();

    Optional<Users> findOne(Long id);
    void delete(Long id);
}
