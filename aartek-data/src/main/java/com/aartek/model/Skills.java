package com.aartek.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * 
 * @author Vivek,22/04/2015
 * 
 */
@Entity
@Table(name = "skills")
public class Skills {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SKILLS_ID")
	private Integer skillsId;

	@Column(name = "SKILLS")
	private String skills;

	@Column(name = "CREATED_DATE")
	private String createdDate;

	@Column(name = "UPDATED_DATE")
	private String updatedDate;

	@Column(name = "IS_DELETED")
	private Integer isDeleted;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "SKILLS_ID")
	private List<Registration> registrationList;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "SKILLS_ID")
	private List<Interviewer> interviewerList;

	public List<Interviewer> getInterviewerList() {
		return interviewerList;
	}

	public void setInterviewerList(List<Interviewer> interviewerList) {
		this.interviewerList = interviewerList;
	}

	public Integer getSkillsId() {
		return skillsId;
	}

	public void setSkillsId(Integer skillsId) {
		this.skillsId = skillsId;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

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

	public List<Registration> getRegistrationList() {
		return registrationList;
	}

	public void setRegistrationList(List<Registration> registrationList) {
		this.registrationList = registrationList;
	}
}
