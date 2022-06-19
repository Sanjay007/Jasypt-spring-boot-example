package com.frugalis.jasypt.service.impl;

import com.frugalis.jasypt.entity.Users;
import com.frugalis.jasypt.repository.UsersRepository;
import com.frugalis.jasypt.service.UsersService;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    private final Logger log = LoggerFactory.getLogger(UsersServiceImpl.class);

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Users save(Users users) {
        log.debug("Request to save users : {}", users);
        return usersRepository.save(users);
    }

    @Override
    public Users update(Users users) {
        log.debug("Request to save users : {}", users);
        return usersRepository.save(users);
    }

    @Override
    public Optional<Users> partialUpdate(Users users) {
        log.debug("Request to partially update users : {}", users);

        return usersRepository
            .findById(users.getId())
            .map(existingusers -> {
                if (users.getName() != null) {
                    existingusers.setName(users.getName());
                }
                if (users.getAge() != null) {
                    existingusers.setAge(users.getAge());
                }
                if (users.getCity() != null) {
                    existingusers.setCity(users.getCity());
                }
                if (users.getEmail() != null) {
                    existingusers.setEmail(users.getEmail());
                }

                return existingusers;
            })
            .map(usersRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Users> findAll() {
        log.debug("Request to get all USERS");
        return usersRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Users> findOne(Long id) {
        log.debug("Request to get users : {}", id);
        return usersRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete users : {}", id);
        usersRepository.deleteById(id);
    }
}
