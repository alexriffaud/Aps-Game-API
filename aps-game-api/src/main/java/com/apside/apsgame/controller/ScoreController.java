package com.apside.apsgame.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apside.apsgame.model.Score;
import com.apside.apsgame.repository.ScoreRepository;

@RestController
@RequestMapping("/api/v1/apsgame")
public class ScoreController {
	@Autowired
	private ScoreRepository scoreRepository;
	
	@GetMapping("/scores")
	public ResponseEntity<List<Score>> getAllFeatures() {
		List<Score> score = new ArrayList<>();
		try {
			System.out.println("**************** ScoreController ****************");
			score = scoreRepository.findAll();
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(score, HttpStatus.OK);
	}
}