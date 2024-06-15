package com.project.JobFinder.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
public class JobProfile {
	
	public JobProfile() {
		super();
	}
	@Id @GeneratedValue
	private Long id;
	private String name;
	private String details;
	private String companyName;
	private Integer salary;
	private String email;
	private Integer experience;
	private List<String> skills;
	public JobProfile(String name, String details, String companyName, Integer salary, String email, Integer experience,
			List<String> skills) {
		super();
		this.name = name;
		this.details = details;
		this.companyName = companyName;
		this.salary = salary;
		this.email = email;
		this.experience = experience;
		this.skills = skills;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	

	
}
