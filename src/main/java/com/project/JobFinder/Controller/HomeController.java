package com.project.JobFinder.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.JobFinder.Model.JobProfile;
import com.project.JobFinder.Repository.JobProfileRepository;
import com.project.JobFinder.Service.JobProfileService;

@Controller
public class HomeController {
	
	@Autowired
	private JobProfileRepository jobProfileRepository;
	
	@Autowired
	private JobProfileService jobProfileService;
	
	@RequestMapping({"/","/home"})
	public String home() {
		return "home";
	}
	
	@RequestMapping("/JobProfileHome")
	public String JobProfileHome(Model model) {
		model.addAttribute("profiles",jobProfileRepository.findAll());
		return "JobProfileHome";
	}
	
	@PostMapping("/SearchValue")
	public String SearchValue(@RequestParam("value") String value,Model model) {
		model.addAttribute("profiles",jobProfileService.searchByValue(value));
		return "JobProfileHome";
	}
	
	@RequestMapping("/ApplyForJob")
	public String ApplyForjob(Model model) {
		System.out.println("Applied for the Job, Now Pls Wait for the response");
		model.addAttribute("profiles",jobProfileRepository.findAll());
		return "JobProfileHome";
	}

}