package com.traini8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traini8.dao.TrainingCenterRepository;
import com.traini8.entities.TrainingCenter;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TrainingCenterService {

	@Autowired
	private TrainingCenterRepository trainingCenterRepository;
	
	// Method to add a new training center
	@Transactional
	public TrainingCenter addCenter(TrainingCenter center) {
		TrainingCenter result = this.trainingCenterRepository.save(center);
		return result;
	}
	
	// Method to search for training centers based on criteria
	public List<TrainingCenter> searchCenters(String centerName, String centerCode, Long studentCapacity,
            List<String> coursesOffered, String contactEmail, Long contactPhone, String createdOn, String city, String state, Long pincode) {
		return trainingCenterRepository.searchCenters(centerName, centerCode, studentCapacity, coursesOffered,
				contactEmail, contactPhone, createdOn, city, state, pincode);
	}
}
