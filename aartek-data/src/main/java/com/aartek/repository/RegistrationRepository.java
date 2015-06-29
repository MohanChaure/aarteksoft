package com.aartek.repository;

import java.util.List;

import com.aartek.model.Interviewer;
import com.aartek.model.Registration;
import com.aartek.model.Schedule;
import com.aartek.model.Skills;

public interface RegistrationRepository {
	public void saveCandidate(Registration registration);

	public List<Skills> getSkillList();

	public void updateCandidate(Registration registration);

	public List<Registration> getCandidateDetails();

	public void deleteCandidateById(Integer registrationId);

	public Registration editStudentDetails(Integer registrationId);
	/*public List<Registration> getScheduledCandidateDetails(
			Integer registrationId);

	public List<InterviewerList> getInterviewerDetails();*/
}
