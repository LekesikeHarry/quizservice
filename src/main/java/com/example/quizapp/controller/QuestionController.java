package com.example.quizapp.controller;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.Response;
import com.example.quizapp.service.QuestionService;
import com.example.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @Autowired
    private QuizService quizService;


    @GetMapping("/login")
    public String login(@RequestHeader("userID") String userID,
                        @RequestHeader("userPassword") String userPassword) {
        // Handle the login logic here
        return "User ID: " + userID + ", User Password: " + userPassword;
    }

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
       return questionService.getAllQuestions();
    }
    @GetMapping("/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }


}
