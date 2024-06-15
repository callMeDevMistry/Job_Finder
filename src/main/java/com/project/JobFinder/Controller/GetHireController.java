package com.project.JobFinder.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.JobFinder.Model.JobProfile;
import com.project.JobFinder.Repository.JobProfileRepository;

@Controller
public class GetHireController {
	
	@Autowired
	private JobProfileRepository jobProfileRepository;
	
	@RequestMapping("/newJob")
	public String newJob() {
		return "newJobForm";
	}
	
	@PostMapping("/addNewJob")
	public String addNewJob(@ModelAttribute("JobProfile") JobProfile jp,Model model) {
		jobProfileRepository.save(jp);
		model.addAttribute("profiles", jobProfileRepository.findAll());
		return "JobProfileHome";
	}

}
