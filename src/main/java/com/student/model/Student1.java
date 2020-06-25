package com.student.model;

import java.util.List;

public class Student1 {
private String firstName;
private String lastName;
private String email;
private String programme;
private List<String> courses;
/**
 * @return the firstName
 */
public String getFirstName() {
	return firstName;
}
/**
 * @param firstName the firstName to set
 */
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
/**
 * @return the lastName
 */
public String getLastName() {
	return lastName;
}
/**
 * @param lastName the lastName to set
 */
public void setLastName(String lastName) {
	this.lastName = lastName;
}
/**
 * @return the email
 */
public String getEmail() {
	return email;
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * @return the programme
 */
public String getProgramme() {
	return programme;
}
/**
 * @param programme the programme to set
 */
public void setProgramme(String programme) {
	this.programme = programme;
}
/**
 * @return the courses
 */
public List<String> getCourses() {
	return courses;
}
/**
 * @param courses the courses to set
 */
public void setCourses(List<String> courses) {
	this.courses = courses;
}
}
