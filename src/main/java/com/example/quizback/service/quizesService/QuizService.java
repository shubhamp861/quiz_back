package com.example.quizback.service.quizesService;

import com.example.quizback.model.quizDTO.QuizDto;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface QuizService {

    QuizDto createOrUpdateQuiz(QuizDto quizDto);
    Set<QuizDto> getAllQQuiz();
    QuizDto getQuizById(Long id);
    String deleteQuiz(Long id);
}
