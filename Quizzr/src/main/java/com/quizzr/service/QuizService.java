package com.quizzr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizzr.dao.QuestionDao;
import com.quizzr.dao.QuizDao;
import com.quizzr.model.Question;
import com.quizzr.model.QuestionWrapper;
import com.quizzr.model.Quiz;
import com.quizzr.model.Response;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;

	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int num, String title) {
		List<Question> questions = questionDao.findRandomQuestionsByCategory(category, num);

		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);

		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questionfromDB = quiz.get().getQuestions();
		List<QuestionWrapper> questionForUser = new ArrayList<>();

		for (Question q : questionfromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getquestionTitle(), q.getOption1(), q.getOption2(),
					q.getOption3(), q.getOption4());
			questionForUser.add(qw);
		}

		return new ResponseEntity<>(questionForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
		Quiz quiz = quizDao.findById(id).get();
		List<Question> questions = quiz.getQuestions();
		
		int right = 0;
		int i = 0;
		for(Response response : responses) {
			if(response.getResponse().equals(questions.get(i).getrightAnswer())){
					right++;
			}
			i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}

}
