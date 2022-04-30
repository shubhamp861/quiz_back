package com.example.quizback.repo.quizRepo;

import com.example.quizback.model.quizDTO.QuizDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<QuizDto,Long> {

}
