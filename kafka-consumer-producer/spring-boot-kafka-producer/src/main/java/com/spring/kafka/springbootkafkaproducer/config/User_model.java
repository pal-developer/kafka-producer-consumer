package com.spring.kafka.springbootkafkaproducer.config;

public class User_model {
	private String name;
	private String dept;
	private String course;
	
	
	
	public User_model() {
		
	}



	public User_model(String name, String dept, String course) {
		this.name = name;
		this.dept = dept;
		this.course = course;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDept() {
		return dept;
	}



	public void setDept(String dept) {
		this.dept = dept;
	}



	public String getCourse() {
		return course;
	}



	public void setCourse(String course) {
		this.course = course;
	}



	@Override
	public String toString() {
		return "User_model [name=" + name + ", dept=" + dept + ", course=" + course + "]";
	}
	
	
	
	
	
}
