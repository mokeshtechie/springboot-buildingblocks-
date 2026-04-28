package com.example.rest.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="user_table")
public class User {
	
	public User() {
		super();		
	}
	public User(Long sno, String firstName, String lastName, String email, String role, String ssn) {
		super();
		this.sno = sno;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		}
	@Override
	public String toString() {
		return "user [sno=" + sno + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", role=" + role + ", ssn=" + ssn + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="s_no",nullable=false,unique=true)
	private Long sno;
	
	public Long getSno() {
		return sno;
	}
	public void setSno(Long sno) {
		this.sno = sno;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	@Column(name="first_name",nullable=false,length=50)
	private String firstName;
	@Column(name="last_name",nullable=false,length=50)
	private String lastName;
	@Column(name="email",length=50)
	private String email;
	@Column(name="role",nullable=false,length=5)
	private String role;
	@Column(name="ssn",nullable=false,unique=true)
	private String ssn;

}
