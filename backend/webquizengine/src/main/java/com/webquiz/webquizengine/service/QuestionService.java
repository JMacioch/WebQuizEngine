package com.webquiz.webquizengine.service;

import com.webquiz.webquizengine.dto.CorrectAnswerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.webquiz.webquizengine.model.Question;
import com.webquiz.webquizengine.repository.QuestionRepository;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Optional<CorrectAnswerDTO> getCorrectAnswer(int id) {
        return questionRepository.findById(id)
                .map(q -> new CorrectAnswerDTO(q.getCorrectAnswer())); 
    }
}
