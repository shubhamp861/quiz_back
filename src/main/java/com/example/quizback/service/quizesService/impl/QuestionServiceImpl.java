package com.example.quizback.service.quizesService.impl;

import com.example.quizback.model.quizDTO.QuestionDto;
import com.example.quizback.model.quizDTO.QuizDto;
import com.example.quizback.repo.quizRepo.QuestionRepo;
import com.example.quizback.service.quizesService.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;
@Component
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public QuestionDto createOrUpdateQuestion(QuestionDto questionDto) {
        return questionRepo.save(questionDto);
    }

    @Override
    public Set<QuestionDto> getAllQuestion() {
        return new LinkedHashSet<>(questionRepo.findAll());
    }

    @Override
    public QuestionDto getQuestionById(Long id) {
        return questionRepo.findById(id).get();
    }

    @Override
    public String deleteQuestion(QuestionDto questionDto) {
        questionRepo.delete(questionDto);
        return "Record Deleted ||";
    }

    @Override
    public Set<QuestionDto> getQuestionsOfQuizes(QuizDto quizDto) {
        return questionRepo.findByQuizDto(quizDto);
    }
}
