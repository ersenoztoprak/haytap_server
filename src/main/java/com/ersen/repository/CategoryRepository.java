package com.ersen.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ersen.entity.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

	Optional<Category> findOneById(long id);
}
