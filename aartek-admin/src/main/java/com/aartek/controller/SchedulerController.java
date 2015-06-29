package com.aartek.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.aartek.model.Interviewer;
import com.aartek.model.Schedule;
import com.aartek.service.SchedulerService;

@Controller
public class SchedulerController {

	@Autowired
	private SchedulerService schedulerService;

	@RequestMapping(value = { "/viewScheduledCandidate" })
	public String viewScheduledCandidate(Map<String, Object> map,
			ModelMap model, @ModelAttribute Schedule schedule,
			@RequestParam(required = false) Integer registrationId,@RequestParam(value = "skillId",required=false) Integer skillId) {
		map.put("Schedule", new Schedule());
		List<Interviewer> interviewerList = schedulerService
				.getInterviewerDetails(skillId);
		model.addAttribute("interviewerList", interviewerList);
		List<Schedule> scheduledCandidateDetails = schedulerService
				.getScheduledCandidateDetails(registrationId);
		model.addAttribute("scheduledCandidateDetails",
				scheduledCandidateDetails);
		return "schedule";
	}

	@RequestMapping(value = "/saveScheduledCandidate", method = RequestMethod.POST)
	public String saveScheduledCandidate(@RequestParam("fileUpload") MultipartFile file,
			@ModelAttribute("Schedule") Schedule schedule,
			@RequestParam CommonsMultipartFile[] fileUpload, String fileName,
			BindingResult result, ModelMap model) throws Exception {
		//schedulerService.saveCandidate(registration);
		return "redirect:/welcome.do";
	}
}
