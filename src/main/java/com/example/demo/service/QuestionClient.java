package com.example.demo.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Question;

@FeignClient(url="http://localhost:8002",value="Question-client")
public interface QuestionClient {
	
	@GetMapping("/question/quiz/{quizId}")
	List<Question> getQuestionQuiz(@PathVariable Long quizId);
		
	

}
