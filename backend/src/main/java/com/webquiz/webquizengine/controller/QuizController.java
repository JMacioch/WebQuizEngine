package com.webquiz.webquizengine.controller;

import com.webquiz.webquizengine.dto.QuestionDTO;
import com.webquiz.webquizengine.dto.QuizDTO;
import com.webquiz.webquizengine.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<QuizDTO> getQuizById(@PathVariable int quizId) {
        Optional<QuizDTO> quiz = quizService.getQuizById(quizId);
        return quiz.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{quizId}/questions")
    public ResponseEntity<List<QuestionDTO>> getAllQuestions(@PathVariable int quizId) {
        try {
            List<QuestionDTO> questions = quizService.getAllQuestions(quizId);
            return ResponseEntity.ok(questions);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/{quizId}/questions/{questionId}")
    public ResponseEntity<QuestionDTO> getQuestionById(@PathVariable int quizId, @PathVariable int questionId) {
        Optional<QuestionDTO> question = quizService.getQuestionById(quizId, questionId);
        return question.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
