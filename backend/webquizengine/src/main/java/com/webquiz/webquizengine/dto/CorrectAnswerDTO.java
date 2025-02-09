package com.webquiz.webquizengine.dto;

public class CorrectAnswerDTO {
    private int correctAnswer;

    public CorrectAnswerDTO(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
