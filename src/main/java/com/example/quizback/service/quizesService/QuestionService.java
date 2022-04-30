package com.example.quizback.service.quizesService;

import com.example.quizback.model.quizDTO.QuestionDto;
import com.example.quizback.model.quizDTO.QuizDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface QuestionService {
    QuestionDto createOrUpdateQuestion(QuestionDto questionDto);
    Set<QuestionDto> getAllQuestion();
    QuestionDto getQuestionById(Long id);
    String deleteQuestion(QuestionDto questionDto);
    Set<QuestionDto> getQuestionsOfQuizes(QuizDto quizDto);
}
