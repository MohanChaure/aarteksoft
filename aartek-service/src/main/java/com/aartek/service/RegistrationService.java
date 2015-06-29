package com.aartek.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.aartek.model.Interviewer;
import com.aartek.model.Registration;
import com.aartek.model.Schedule;
import com.aartek.model.Skills;

public interface RegistrationService {
	public List<Skills> getSkillList();

	public void saveCandidate(Registration registration);

	public void uploadResume(Registration registration, MultipartFile filePart, CommonsMultipartFile[] fileUpload,
					String fileName);

	public List<Registration> getCandidateDetails();

	public void deleteCandidateById(Integer registrationId);

	public Registration editSudentDetails(Integer registrationId);
	/*public List<Registration> getScheduledCandidateDetails(Integer registrationId);*/

	/*public List<InterviewerList> getInterviewerDetails();*/
}
