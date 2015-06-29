package com.aartek.repository;

import java.util.List;

import com.aartek.model.Interviewer;
import com.aartek.model.Schedule;

public interface SchedulerRepository {

	public List<Schedule> getScheduledCandidateDetails(
			Integer registrationId);

	public List<Interviewer> getInterviewerDetails(Integer skillId);

}
