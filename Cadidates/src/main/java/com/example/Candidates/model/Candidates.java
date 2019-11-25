package com.example.Candidates.model;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Candidates {
	@Id
	@Generated(value = "com.acme.generator.CodeGen")
	String id;

	String name;

	List<String> skills;

	String age;

	int DXC;

	int creditsEarned;

	@DBRef
	List<Posts> selectedPosts;

	@DBRef
	List<Posts> appliedPosts;

	public Candidates() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSkills() {
		return skills;
	}

	public int getCreditsEarned() {
		return creditsEarned;
	}

	public void setCreditsEarned(int creditsEarned) {
		this.creditsEarned = creditsEarned;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int getDXC() {
		return DXC;
	}

	public void setDXC(int dXC) {
		DXC = dXC;
	}

	public List<Posts> getSelectedPosts() {
		return selectedPosts;
	}

	public void setSelectedPosts(List<Posts> selectedPosts) {
		this.selectedPosts = selectedPosts;
	}

	public List<Posts> getAppliedPosts() {
		return appliedPosts;
	}

	public void setAppliedPosts(List<Posts> appliedPosts) {
		this.appliedPosts = appliedPosts;
	}

	@Override
	public String toString() {
		return "Candidates [id=" + id + ", name=" + name + ", skills=" + skills + ", age=" + age + ", DXC=" + DXC
				+ ", creditsEarned=" + creditsEarned + ", selectedPosts=" + selectedPosts + ", appliedPosts="
				+ appliedPosts + "]";
	}
	
	

}
