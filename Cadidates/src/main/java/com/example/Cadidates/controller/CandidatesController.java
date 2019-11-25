package com.example.Cadidates.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Cadidates.repo.CandidatesDAL;
import com.example.Cadidates.repo.PostsDAL;
import com.example.Candidates.model.Candidates;
import com.example.Candidates.model.Posts;

@RestController
public class CandidatesController {

	@Autowired
	CandidatesDAL candi;
	
	@Autowired
	PostsDAL post;
	
	@PostMapping("/candidates")
	public void Posts(@RequestBody Candidates candy)
	{
		candi.save(candy);
	}
	
	@GetMapping("/candidates")
	public List<Candidates> fetch()
	{
		return candi.findAll();
		
	}
	
}
