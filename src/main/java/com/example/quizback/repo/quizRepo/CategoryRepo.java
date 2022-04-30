package com.example.quizback.repo.quizRepo;

import com.example.quizback.model.quizDTO.CategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<CategoryDto,Long> {
}
