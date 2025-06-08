package com.mcgill.java;

import java.util.concurrent.*;
import java.io.Serializable;
import java.util.*;

public class Student implements Serializable{
	private int id;
	private String name;
	private String email;
	
	//Constructors
	public Student () {
		
	}
	
	public Student(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	//Getters and Setters
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}

	@Override
	public String toString() {
		return "Student{ id=" + id + " , name= " + name + " email= " + email + "}";
	}
}
