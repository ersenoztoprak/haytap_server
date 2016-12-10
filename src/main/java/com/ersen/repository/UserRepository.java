package com.ersen.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ersen.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	Optional<User> findOneByUsername(String username);

	Optional<User> findOneByEmail(String email);

	Optional<User> findOneById(long userId);

}
