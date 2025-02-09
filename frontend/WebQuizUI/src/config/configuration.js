const apiBaseUrl = 'http://localhost:8080';



export const getUrl = (endpoint) => `${apiBaseUrl}${endpoint}`;


export const apiConfig = {
  timeout: 5000, // Maksymalny czas oczekiwania na odpowiedź (w ms)
  headers: {
    'Content-Type': 'application/json',
  },
};

export default {
  apiBaseUrl,
  getUrl,
  apiConfig,
};