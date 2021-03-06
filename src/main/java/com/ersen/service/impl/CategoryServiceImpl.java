package com.ersen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ersen.entity.Category;
import com.ersen.exception.CategoryNotFoundException;
import com.ersen.repository.CategoryRepository;
import com.ersen.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	private CategoryRepository categoryRespository;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRespository) {
		this.categoryRespository = categoryRespository;
	}
	
	@Override
	public Category getCategory(Long id) {
		return categoryRespository.findOneById(id).orElseThrow(() -> new CategoryNotFoundException());
	}
}
