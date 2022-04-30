package com.example.quizback.repo.quizRepo;

import com.example.quizback.model.quizDTO.QuestionDto;
import com.example.quizback.model.quizDTO.QuizDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepo extends JpaRepository<QuestionDto,Long> {
    Set<QuestionDto> findByQuizDto(QuizDto quizDto);
}
