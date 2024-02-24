package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Quiz;
import com.example.demo.implService.QuizeImplService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	QuizeImplService quizeImpl;
	
	@PostMapping
	public Quiz saveAllQuiz(@RequestBody Quiz quiz) {
		return this.quizeImpl.addAllQuiz(quiz);
	}
	
	@GetMapping
	public List<Quiz> getAllQuiz(){
		return this.quizeImpl.getAllQuize();
	}
	
	
	@GetMapping("/{id}")
	public Quiz getSingleQuize(@PathVariable Long id) {
		return this.quizeImpl.getSingleQuiz(id);
	}

}
