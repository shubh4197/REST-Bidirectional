package com.example.Cadidates.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Cadidates.repo.CandidatesDAL;
import com.example.Cadidates.repo.PostsDAL;
import com.example.Candidates.model.Candidates;
import com.example.Candidates.model.Posts;

@RestController
public class PostsController {

	@Autowired
	CandidatesDAL candi;

	@Autowired
	PostsDAL postRepo;

	@PostMapping("/posts")
	public void Posts(@RequestBody Posts post1) {
		postRepo.save(post1);
	}

	@PutMapping("/postsApply/{id}/{id1}")
	public void Apply(@PathVariable String id1, @PathVariable String id) {
		Candidates candy = candi.find(id1);
		Posts post1 = postRepo.find(id);
		List<Candidates> lol = new ArrayList<>();
		List<Posts> lol2 = new ArrayList<>();
		if (post1.getAppliedCandidates() != null) {
			lol = post1.getAppliedCandidates();
		}
		lol.add(candy);
		post1.setAppliedCandidates(lol);
		if (candy.getAppliedPosts() != null) {
			lol2 = candy.getAppliedPosts();
		}
		lol2.add(post1);
		candy.setAppliedPosts(lol2);
		candi.save(candy);
		postRepo.save(post1);
	}

	@PutMapping("/postsAccept/{id}/{id1}")
	public void Accept(@PathVariable String id1, @PathVariable String id) {
		Candidates candy = candi.find(id1);
		Posts post1 = postRepo.find(id);
		List<Candidates> lol = new ArrayList<>();
		List<Posts> lol2 = new ArrayList<>();
		if (post1.getSelectedCandidates() != null) {
			lol = post1.getSelectedCandidates();
		}
		lol.add(candy);
		post1.setSelectedCandidates(lol);
		if (candy.getSelectedPosts() != null) {
			lol2 = candy.getSelectedPosts();
		}
		lol2.add(post1);
		candy.setSelectedPosts(lol2);
		candi.save(candy);
		postRepo.save(post1);
	}

	@PutMapping("/postsDecline/{postId}/{candidateId}")
	public void decline(@PathVariable String candidateId, @PathVariable String postId) {
		Candidates candidate = candi.find(candidateId);
		Posts post = postRepo.find(postId);
		int index=0;
		int index1=0;
		List<Candidates> lol = post.getAppliedCandidates();
		for(Candidates i:lol)
		{
			if(i==candidate)
			{
				 index=lol.indexOf(i);
			}
		}
		lol.remove(index);
		post.setAppliedCandidates(lol);
		List<Posts> lol2 = candidate.getAppliedPosts();
		for(Posts i:lol2)
		{
			if(i==post)
			{
				 index1=lol.indexOf(i);
			}
		}
		lol2.remove(index1);
		candidate.setAppliedPosts(lol2);
	    candi.save(candidate);
		postRepo.save(post);

	}
	
	@GetMapping("/posts")
	public List<Posts> fetch(){
		return postRepo.findAll();
	}
	
}
