import axios from 'axios';
import { getUrl, apiConfig } from '../config/configuration';

export const fetchQuestions = async (quizId) => {
  try {
    const response = await axios.get(getUrl(`/quizzes/${quizId}/questions`), {
      headers: apiConfig.headers,
      timeout: apiConfig.timeout,
    });
    return response.data;
  } catch (error) {
    console.error('Błąd pobierania pytań:', error);
    throw new Error('Nie udało się pobrać pytań.');
  }
};


export const fetchQuestionById = async (quizId, questionId) => {
  try {
    const response = await axios.get(getUrl(`/quizzes/${quizId}/questions/${questionId}`), {
      headers: apiConfig.headers,
      timeout: apiConfig.timeout,
    });
    return response.data;
  } catch (error) {
    console.error(`Błąd pobierania pytania z ID ${questionId}:`, error);
    throw new Error('Nie udało się pobrać pytania.');
  }
};


export const fetchCorrectAnswer = async (questionId) => {
  try {
    const response = await axios.get(getUrl(`/questions/${questionId}/answer`), {
      headers: apiConfig.headers,
      timeout: apiConfig.timeout,
    });
    return response.data.correctAnswer; 
  } catch (error) {
    console.error(`Błąd pobierania poprawnej odpowiedzi dla pytania ${questionId}:`, error);
    throw new Error("Nie udało się pobrać poprawnej odpowiedzi.");
  }
};

export default {
  fetchQuestions,
  fetchQuestionById,
  fetchCorrectAnswer,
};

