package com.quizzr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizzr.dao.QuestionDao;
import com.quizzr.model.Question;

@Service
public class QuestionService {
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK) ;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(questionDao.findAll(), HttpStatus.BAD_REQUEST) ;
	}

	
	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
			return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK) ;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.BAD_REQUEST) ;
	}


	public ResponseEntity<String> addQuestion(Question question) {
		try {
			questionDao.save(question);
			return new ResponseEntity<>("Success", HttpStatus.OK) ;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST) ;
	}

	public Optional<Question> getQuestionsById(int id) {
		return questionDao.findById(id);
		
	}


	public void deleteQuestion(int id) {
		questionDao.deleteById(id);
		
	}

	
}
