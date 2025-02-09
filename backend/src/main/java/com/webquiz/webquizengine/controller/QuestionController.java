package com.webquiz.webquizengine.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import com.webquiz.webquizengine.model.Question;
import com.webquiz.webquizengine.dto.CorrectAnswerDTO;
import com.webquiz.webquizengine.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/{id}/answer")
    public ResponseEntity<CorrectAnswerDTO> getCorrectAnswer(@PathVariable int id) {
        Optional<CorrectAnswerDTO> answer = questionService.getCorrectAnswer(id);
        return answer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
