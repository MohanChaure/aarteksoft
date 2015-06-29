package com.aartek.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.Interviewer;
import com.aartek.model.Schedule;
import com.aartek.repository.SchedulerRepository;

@Repository
@SuppressWarnings("unchecked")
public class SchedulerRepositoryImpl implements SchedulerRepository{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Schedule> getScheduledCandidateDetails(Integer registrationId) {
	
		List<Schedule> candidateList = (List<Schedule>) hibernateTemplate
						.find("from Registration  where registrationId='"+registrationId+"'");
		return candidateList;

	}

	@Override
	public List<Interviewer> getInterviewerDetails(Integer skillId) {
			List<Interviewer> skillList = (List<Interviewer>) hibernateTemplate.find("from Interviewer where skills.skillsId= "+skillId);
			return skillList;
	}

}
