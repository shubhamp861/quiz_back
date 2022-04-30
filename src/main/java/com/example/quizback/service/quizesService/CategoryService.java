package com.example.quizback.service.quizesService;

import com.example.quizback.model.quizDTO.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public interface CategoryService {

    CategoryDto createOrUpdateCategory(CategoryDto categoryDto);
    Set<CategoryDto> getAllCategory();
    CategoryDto getCategoryById(Long id);
    String deleteCategory(CategoryDto categoryDto);

}
