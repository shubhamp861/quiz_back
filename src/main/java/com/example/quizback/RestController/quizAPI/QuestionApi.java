package com.example.quizback.RestController.quizAPI;

import com.example.quizback.model.quizDTO.QuestionDto;
import com.example.quizback.service.quizesService.QuestionService;
import com.example.quizback.service.quizesService.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionApi {

    @Autowired
    private QuestionService questionService;

    @PostMapping(value = {"/add","/update"})
    public ResponseEntity<QuestionDto> createOrUpdate(@RequestBody QuestionDto questionDto){
        return  new ResponseEntity<>(questionService.createOrUpdateQuestion(questionDto), HttpStatus.OK);
    }

    @GetMapping("/getQuestion/{id}")
    public ResponseEntity<?> getCategory(@PathVariable("id") long id){
        return new ResponseEntity<>(questionService.getQuestionById(id),HttpStatus.OK);
    }

    @GetMapping("/getAllQuestion")
    public ResponseEntity<?> getAllCategory(){
        return new ResponseEntity<>(questionService.getAllQuestion(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") long id){
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQid(id);
        return ResponseEntity.ok(questionService.deleteQuestion(questionDto));
    }
    /*@GetMapping("/getAllQuizForQuestion/{id}")
    public ResponseEntity<?> getAllQuizForQuestion(@PathVariable("id") Long id){
        QuizDto quizDto = new QuizDto();
        quizDto.setQid(id);
        return ResponseEntity.ok(questionService.getQuestionsOfQuizes(quizDto));
    }*/
}
