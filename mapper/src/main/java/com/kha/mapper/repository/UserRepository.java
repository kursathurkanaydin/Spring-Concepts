package com.kha.mapper.repository;

import com.kha.mapper.dto.UserDto;
import com.kha.mapper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmail(String email);
    boolean existsUserByEmail(String email);
    boolean deleteUserByEmail(String email);
}
