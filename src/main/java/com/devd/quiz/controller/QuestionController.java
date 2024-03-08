package com.devd.quiz.controller;

import com.devd.quiz.model.Question;
import com.devd.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        try {
            return new ResponseEntity<>(questionService.getAllQuestions(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("type/{type}")
    public ResponseEntity<List<Question>> getQuestionByType(@PathVariable String  type){
        try {
            return new ResponseEntity<>(questionService.getQuestionByType(type), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    @GetMapping("difficulty/{difficulty}")
    public ResponseEntity<List<Question>> getQuestionByDifficulty(@PathVariable String difficulty){
        try {
            return new ResponseEntity<>(questionService.getQuestionByDifficulty(difficulty), HttpStatus.OK)

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return  new ResponseEntity<>(questionService.addQuestion(question), HttpStatus.CREATED);
    }

}
