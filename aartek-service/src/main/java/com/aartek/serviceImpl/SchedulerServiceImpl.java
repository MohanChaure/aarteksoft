package com.aartek.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.Interviewer;
import com.aartek.model.Schedule;
import com.aartek.repository.SchedulerRepository;
import com.aartek.service.SchedulerService;

@Service
public class SchedulerServiceImpl implements SchedulerService{
	@Autowired
	private SchedulerRepository schedulerRepository;


	public List<Schedule> getScheduledCandidateDetails(Integer registrationId) {
		List<Schedule> list = schedulerRepository.getScheduledCandidateDetails(registrationId);
		return list;
	}
	
	public List<Interviewer> getInterviewerDetails(Integer skillId) {
		return schedulerRepository.getInterviewerDetails(skillId);
	}
}
