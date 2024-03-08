package com.devd.quiz.dao;

import com.devd.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findByType(String type);

    List<Question> findByDifficulty(String difficulty);
}
