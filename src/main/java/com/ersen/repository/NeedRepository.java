package com.ersen.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ersen.entity.Need;

public interface NeedRepository extends PagingAndSortingRepository<Need, Long> {

}
