package com.example.quizback.RestController.quizAPI;

import com.example.quizback.model.quizDTO.CategoryDto;
import com.example.quizback.model.quizDTO.QuizDto;
import com.example.quizback.service.quizesService.CategoryService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryApi {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = {"/add","/update"})
    public ResponseEntity<CategoryDto>  createOrUpdate(@RequestBody CategoryDto categoryDto){
        return  new ResponseEntity<>(categoryService.createOrUpdateCategory(categoryDto), HttpStatus.OK);
    }

     @GetMapping("/test")
    public ResponseEntity<?> getCategory(){
        return new ResponseEntity<>("Test",HttpStatus.OK);
    }
    
    
    @GetMapping("/getCategory/{id}")
    public ResponseEntity<?> getCategory(@PathVariable("id") long id){
        return new ResponseEntity<>(categoryService.getCategoryById(id),HttpStatus.OK);
    }

    @GetMapping("/getAllCategory")
    public ResponseEntity<?> getAllCategory(){
        return new ResponseEntity<>(categoryService.getAllCategory(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") long id){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCid(id);
        return ResponseEntity.ok(categoryService.deleteCategory(categoryDto));
    }
}
