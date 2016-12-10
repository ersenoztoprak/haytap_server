package com.ersen.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.ersen.entity.Customer;


public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>{

	Customer getById(Long id);
	
	void deleteById(Long id);
	
	@Modifying(clearAutomatically = true)
    @Query("UPDATE Customer c SET c.age = :age,c.name = :name WHERE c.id = :id")
    void updateCustomer(@Param("id") long id, @Param("age") int age, @Param("name") String name);
}
