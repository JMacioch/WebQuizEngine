package com.webquiz.webquizengine.dto;

import java.util.List;

public class QuizDTO {
    private String title;
    private List<QuestionDTO> questions;
    private int numberOfQuestions;

    public QuizDTO() {}

    public QuizDTO(String title, List<QuestionDTO> questions) {
        this.title = title;
        this.questions = questions;
        this.numberOfQuestions = questions != null ? questions.size() : 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
        this.numberOfQuestions = questions != null ? questions.size() : 0;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }
}
