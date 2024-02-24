package com.example.demo.implService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Quiz;
import com.example.demo.repository.QuizRepository;
import com.example.demo.service.QuestionClient;
import com.example.demo.service.QuizService;

@Service
public class QuizeImplService implements QuizService{

	@Autowired
	QuizRepository quizRepository;
	
	@Autowired
	private QuestionClient questionClient;
	
	@Override
	public Quiz addAllQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> getAllQuize() {
		// TODO Auto-generated method stub
		
		List<Quiz> quezz=this.quizRepository.findAll();
		List<Quiz>newQuiz =quezz.stream().map(quiz -> {
			quiz.setQuestion(questionClient.getQuestionQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		return newQuiz;
	}

	@Override
	public Quiz getSingleQuiz(Long id) {
		// TODO Auto-generated method stub
		Quiz quiz= this.quizRepository.findById(id).orElseThrow();
		quiz.setQuestion(questionClient.getQuestionQuiz(quiz.getId()));
		return quiz;
	}
	
}
