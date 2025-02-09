import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App'; // Import głównego komponentu aplikacji
import './styles/global.css'; // Globalne style aplikacji (jeśli potrzebne)

// Pobranie kontenera root
const root = ReactDOM.createRoot(document.getElementById('root'));

// Renderowanie aplikacji w root
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);