package com.quizzr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizzr.model.Question;
import com.quizzr.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	@Autowired
	QuestionService questionService;
	
	@GetMapping("all")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getquestionsbycategory(@PathVariable String category){
		return questionService.getQuestionsByCategory(category);
	}
	
	@GetMapping("find/{id}")
	public Optional<Question> getquestionsbyId(@PathVariable int id){
		return questionService.getQuestionsById(id);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
	
	@DeleteMapping("delete/{id}")
	public String deletequestion(@PathVariable int id) {
		questionService.deleteQuestion(id);
		return "question deleted";
	}
}
