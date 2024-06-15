package com.project.JobFinder.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.JobFinder.Model.JobProfile;

public interface JobProfileRepository extends JpaRepository<JobProfile,Long>{
	
}
