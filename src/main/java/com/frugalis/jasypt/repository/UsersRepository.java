package com.frugalis.jasypt.repository;

import com.frugalis.jasypt.entity.Users;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
