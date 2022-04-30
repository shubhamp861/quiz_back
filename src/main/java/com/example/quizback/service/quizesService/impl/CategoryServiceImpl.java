package com.example.quizback.service.quizesService.impl;

import com.example.quizback.model.quizDTO.CategoryDto;
import com.example.quizback.repo.quizRepo.CategoryRepo;
import com.example.quizback.service.quizesService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;
@Component
public class CategoryServiceImpl implements CategoryService {

   @Autowired
    CategoryRepo categoryRepo;

    @Override
    public CategoryDto createOrUpdateCategory(CategoryDto categoryDto) {
        return categoryRepo.save(categoryDto);
    }

    @Override
    public Set<CategoryDto> getAllCategory() {
        return new LinkedHashSet<>(categoryRepo.findAll());
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        return categoryRepo.findById(id).get();
    }

    @Override
    public String deleteCategory(CategoryDto categoryDto) {
        categoryRepo.delete(categoryDto);
        return "Record Deleted ||";
    }
}
