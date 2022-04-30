package com.example.quizback.RestController.quizAPI;

import com.example.quizback.model.quizDTO.QuizDto;
import com.example.quizback.service.quizesService.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizApi {

    @Autowired
    QuizService quizService;

    @PostMapping(value = {"/add","/update"})
    public ResponseEntity<QuizDto> createOrUpdate(@RequestBody QuizDto quizDto){
        return  new ResponseEntity<>(quizService.createOrUpdateQuiz(quizDto), HttpStatus.OK);
    }

    @GetMapping("/getQuiz/{id}")
    public ResponseEntity<?> getQuizById(@PathVariable("id") long id){
        return new ResponseEntity<>(quizService.getQuizById(id),HttpStatus.OK);
    }

    @GetMapping("/getAllQuiz")
    public ResponseEntity<?> getAllCategory(){
        return new ResponseEntity<>(quizService.getAllQQuiz(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id){
       // QuizDto quizById = quizService.getQuizById(id);
        return ResponseEntity.ok(quizService.deleteQuiz(id));
    }
    @GetMapping("/getAllQuestionForQuiz/{id}")
    public ResponseEntity<?> getAllQuizForQuestion(@PathVariable("id") Long id){
        QuizDto quizDto = quizService.getQuizById(id);
        quizDto.setQid(id);
        Collections.shuffle(new ArrayList<>(quizDto.getQuestionDto()));
        return ResponseEntity.ok(quizDto.getQuestionDto());
    }
}
