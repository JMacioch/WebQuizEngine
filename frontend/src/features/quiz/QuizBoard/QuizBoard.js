import React, { useState, useEffect } from "react";
import { fetchQuestions, fetchCorrectAnswer } from "../../../services/questionService";
import "./QuizBoard.css";

function QuizBoard() {
  const quizId = 1;
  const [questions, setQuestions] = useState([]);
  const [currentQuestionIndex, setCurrentQuestionIndex] = useState(0);
  const [selectedAnswerIndex, setSelectedAnswerIndex] = useState(null);
  const [correctAnswerIndex, setCorrectAnswerIndex] = useState(null);
  const [showCorrectAnswers, setShowCorrectAnswers] = useState(false);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    async function loadQuestions() {
      try {
        const data = await fetchQuestions(quizId);
        setQuestions(data);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    }
    loadQuestions();
  }, [quizId]);

  if (loading) return <p>Ładowanie pytań...</p>;
  if (error) return <p>Błąd: {error}</p>;
  if (questions.length === 0) return <p>Brak pytań w tym quizie.</p>;

  const currentQuestion = questions[currentQuestionIndex];
  const answers = [
    currentQuestion.option1,
    currentQuestion.option2,
    currentQuestion.option3,
    currentQuestion.option4,
  ];

  const checkAnswer = async (selectedIndex) => {
    setSelectedAnswerIndex(selectedIndex);
    try {
      const correct = await fetchCorrectAnswer(currentQuestion.id); 
      setCorrectAnswerIndex(correct - 1); 
    } catch (err) {
      console.error("Błąd pobierania poprawnej odpowiedzi:", err);
    }
    setShowCorrectAnswers(true);
  };

  const goToNextQuestion = () => {
    setSelectedAnswerIndex(null);
    setCorrectAnswerIndex(null);
    setShowCorrectAnswers(false);
    if (currentQuestionIndex < questions.length - 1) {
      setCurrentQuestionIndex(currentQuestionIndex + 1);
    }
  };

  return (
    <div className="quiz-board">
      <h2>{currentQuestion.text}</h2>
      <div className="answers">
        {answers.map((answer, index) => {
          let answerClass = "answer-button";

          if (showCorrectAnswers) {
            if (index === correctAnswerIndex) {
              answerClass += " correct"; 
            } else if (index === selectedAnswerIndex) {
              answerClass += " incorrect"; 
            }
          }

          return (
            <button
              key={index}
              className={answerClass}
              onClick={() => checkAnswer(index)}
              disabled={showCorrectAnswers}
            >
              {answer}
            </button>
          );
        })}
      </div>
      <button className="btn btn-primary next-button" onClick={goToNextQuestion}>
        Następne pytanie
      </button>
    </div>
  );
}

export default QuizBoard;
