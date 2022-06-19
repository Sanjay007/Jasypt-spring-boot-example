package com.frugalis.jasypt.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import com.frugalis.jasypt.entity.Users;
import com.frugalis.jasypt.repository.UsersRepository;
import com.frugalis.jasypt.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UsersResource {

    private final Logger log = LoggerFactory.getLogger(UsersResource.class);
    private final UsersService usersService;

    private final UsersRepository usersRepository;

    public UsersResource(UsersService usersService, UsersRepository usersRepository) {
        this.usersService = usersService;
        this.usersRepository = usersRepository;
    }


    @PostMapping("/users")
    public ResponseEntity<Users> createUSERS(@RequestBody Users users) throws URISyntaxException {
        log.debug("REST request to save USERS : {}", users);

        Users result = usersService.save(users);
        return ResponseEntity
            .created(new URI("/api/users/" + result.getId()))

            .body(result);
    }


    @GetMapping("/users")
    public List<Users> getAllUSERS() {
        log.debug("REST request to get all USERS");
        return usersService.findAll();
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUSERS(@PathVariable Long id) {
        log.debug("REST request to get USERS : {}", id);
        Optional<Users> users = usersService.findOne(id);
        return ResponseEntity.ok().body(users.get());
    }


}
