import React from 'react';
import Header from './components/Header/Header'; // Import komponentu Header
import QuizBoard from './features/quiz/QuizBoard/QuizBoard'; // Import komponentu QuizBoard
import './styles/global.css'; // Globalne style aplikacji

function App() {
  return (
    <div>
      <Header />
      <main>
        <QuizBoard />
      </main>
    </div>
  );
}

export default App;