package com.aartek.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "interviewer")
public class Interviewer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "INTERVIEWER_ID")
	private Integer interviewerId;

	@Column(name = "INTERVIEWER_FIRST_NAME")
	private String interviewerFirstName;
	
	@Column(name = "INTERVIEWER_LAST_NAME")
	private String interviewerLastName;
	
	@Column(name = "INTERVIEWER_EMAILID")
	private String interviewerEmail;
	
	@Column(name = "INTERVIEWER_PHONE_NO")
	private String interviewerPhoneNo;
	
	@Column(name = "INTERVIEWER_DESIGNATION")
	private String interviewerDesignation;
	
	@ManyToOne
	@JoinColumn(name = "SKILLS_ID")
	private Skills skills;
	
	/*@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "INTERVIEWER_ID")
	private List<Schedule> scheduleList;*/

	@Column(name = "CREATED_DATE")
	private String createdDate;

	@Column(name = "UPDATED_DATE")
	private String updatedDate;
	
	@Column(name = "IS_DELETED")
	private Integer isDeleted;

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getInterviewerId() {
		return interviewerId;
	}

	public void setInterviewerId(Integer interviewerId) {
		this.interviewerId = interviewerId;
	}

	public String getInterviewerFirstName() {
		return interviewerFirstName;
	}

	public void setInterviewerFirstName(String interviewerFirstName) {
		this.interviewerFirstName = interviewerFirstName;
	}

	public String getInterviewerLastName() {
		return interviewerLastName;
	}

	public void setInterviewerLastName(String interviewerLastName) {
		this.interviewerLastName = interviewerLastName;
	}

	public String getInterviewerEmail() {
		return interviewerEmail;
	}

	public void setInterviewerEmail(String interviewerEmail) {
		this.interviewerEmail = interviewerEmail;
	}

	public String getInterviewerPhoneNo() {
		return interviewerPhoneNo;
	}

	public void setInterviewerPhoneNo(String interviewerPhoneNo) {
		this.interviewerPhoneNo = interviewerPhoneNo;
	}

	public String getInterviewerDesignation() {
		return interviewerDesignation;
	}

	public void setInterviewerDesignation(String interviewerDesignation) {
		this.interviewerDesignation = interviewerDesignation;
	}	
	
	public Skills getSkills() {
		return skills;
	}

	public void setSkills(Skills skills) {
		this.skills = skills;
	}

	
}