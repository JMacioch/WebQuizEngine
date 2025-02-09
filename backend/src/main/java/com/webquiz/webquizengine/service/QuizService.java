package com.webquiz.webquizengine.service;

import com.webquiz.webquizengine.dto.QuestionDTO;
import com.webquiz.webquizengine.dto.QuizDTO;
import com.webquiz.webquizengine.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    
    public Optional<QuizDTO> getQuizById(int quizId) {
        return quizRepository.findById(quizId)
                .map(quiz -> {
                    List<QuestionDTO> questionResponses = quiz.getQuestions().stream()
                            .map(q -> new QuestionDTO(
                                    q.getId(),
                                    q.getText(),
                                    q.getOption1(),
                                    q.getOption2(),
                                    q.getOption3(),
                                    q.getOption4()
                            ))
                            .collect(Collectors.toList());
                    return new QuizDTO(quiz.getTitle(), questionResponses);
                });
    }

  
    public List<QuestionDTO> getAllQuestions(int quizId) {
        return quizRepository.findById(quizId)
                .map(quiz -> quiz.getQuestions().stream()
                        .map(q -> new QuestionDTO(
                                q.getId(),
                                q.getText(),
                                q.getOption1(),
                                q.getOption2(),
                                q.getOption3(),
                                q.getOption4()
                        ))
                        .collect(Collectors.toList()))
                .orElseThrow(() -> new IllegalArgumentException("Quiz not found"));
    }

  
    public Optional<QuestionDTO> getQuestionById(int quizId, int questionId) {
        return quizRepository.findById(quizId)
                .flatMap(quiz -> quiz.getQuestions().stream()
                        .filter(question -> question.getId() == questionId)
                        .map(q -> new QuestionDTO(
                                q.getId(),
                                q.getText(),
                                q.getOption1(),
                                q.getOption2(),
                                q.getOption3(),
                                q.getOption4()
                        ))
                        .findFirst());
    }
}
