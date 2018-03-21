package com.ersen.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ersen.entity.Need;
import com.ersen.entity.enums.AdminStatus;

public interface NeedRepository extends PagingAndSortingRepository<Need, Long> {

	@Modifying(clearAutomatically = true)
    @Query("UPDATE Need n SET n.adminStatus = :adminStatus WHERE n.id = :id")
	void approve(Long id, AdminStatus status);

}
