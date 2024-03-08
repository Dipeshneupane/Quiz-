package com.devd.quiz.service;

import com.devd.quiz.dao.QuestionDao;
import com.devd.quiz.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionByType(String type) {
        return questionDao.findByType(type);
    }

    public List<Question> getQuestionByDifficulty(String difficulty) {
        return questionDao.findByDifficulty(difficulty);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "Added Successfully";
    }
}
