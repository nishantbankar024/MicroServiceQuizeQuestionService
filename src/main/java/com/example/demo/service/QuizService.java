package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Quiz;

public interface QuizService {
//	add all quize 
	
	public Quiz addAllQuiz(Quiz quiz);
	
//	get all quize
	public List<Quiz> getAllQuize();
	
//	get single quize
	
	public Quiz getSingleQuiz(Long id);
	
	
	

}
