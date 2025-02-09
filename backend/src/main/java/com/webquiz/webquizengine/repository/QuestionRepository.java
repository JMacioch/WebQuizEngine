package com.webquiz.webquizengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.webquiz.webquizengine.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
