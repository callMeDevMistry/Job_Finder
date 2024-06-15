package com.project.JobFinder.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.JobFinder.Model.JobProfile;
import com.project.JobFinder.Repository.JobProfileRepository;

@Component
public class JobProfileService {
	
	@Autowired
	private JobProfileRepository jobProfileRepository;
	

	public List<JobProfile> searchByValue(String value){
		List<JobProfile> res = new ArrayList<>();
		List<JobProfile> jp =  jobProfileRepository.findAll();
		for(JobProfile profile: jp) {
			if(profile.getCompanyName().toLowerCase().contains(value.toLowerCase().trim())) {
				res.add(profile);
			}
			else if(profile.getDetails().toLowerCase().contains(value.toLowerCase().trim())) {
				res.add(profile);
			}
			else if(profile.getName().toLowerCase().contains(value.toLowerCase().trim())) {
				res.add(profile);
			}
			else {
				for(String skill : profile.getSkills()) {
					if(skill.toLowerCase().contains(value.toLowerCase().trim())) {
						res.add(profile);
					}
				}
			}
		}
		return res;
	}

}
