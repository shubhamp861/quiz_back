package com.example.quizback.service.quizesService.impl;

import com.example.quizback.model.quizDTO.QuizDto;
import com.example.quizback.repo.quizRepo.QuizRepo;
import com.example.quizback.service.quizesService.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;
@Component
public class QuizServicImpl implements QuizService {
    @Autowired
    QuizRepo quizRepo;

    @Override
    public QuizDto createOrUpdateQuiz(QuizDto quizDto) {
        return quizRepo.save(quizDto);
    }

    @Override
    public Set<QuizDto> getAllQQuiz() {
        return new LinkedHashSet<>(quizRepo.findAll());
    }

    @Override
    public QuizDto getQuizById(Long id) {
        return quizRepo.getById(id);
    }

    @Override
    public String deleteQuiz(Long id) {
        quizRepo.deleteById(id);
        return "Record Deleted ||";
    }
}
