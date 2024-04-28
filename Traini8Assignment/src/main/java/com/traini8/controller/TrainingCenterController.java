package com.traini8.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import com.traini8.service.TrainingCenterService;
import com.traini8.entities.TrainingCenter;

@RestController
@RequestMapping("/traini8")
public class TrainingCenterController {

	@Autowired
	private TrainingCenterService trainingCenterService;
	
	// Endpoint for adding a new training center
	@Transactional
	@PostMapping("/training-center")
	public ResponseEntity<TrainingCenter> addCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
		TrainingCenter center = null;
		
		try {
			center = this.trainingCenterService.addCenter(trainingCenter);
			// Return the newly added center with a success status
			return ResponseEntity.of(Optional.of(center));
		} catch(Exception e) {
			e.printStackTrace();
			// If an exception occurs, return an internal server error status
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	// Endpoint for retrieving training centers with optional query parameters
	@GetMapping("/training-centers")
	public ResponseEntity<Map<String, Object>> getCenters(
			@RequestParam (required = false) String centerName,
	        @RequestParam(required = false) String centerCode,
	        @RequestParam(required = false) Long studentCapacity,
	        @RequestParam(required = false) List<String> coursesOffered,
	        @RequestParam(required = false) String contactEmail,
	        @RequestParam(required = false) Long contactPhone,
	        @RequestParam(required = false) String createdOn,
	        @RequestParam(required = false) String city,
	        @RequestParam(required = false) String state,
	        @RequestParam(required = false) Long pincode){
		 
		// Search for training centers based on provided criteria
		List<TrainingCenter> list = trainingCenterService.searchCenters(centerName, centerCode, studentCapacity,
	        coursesOffered, contactEmail, contactPhone, createdOn, city, state, pincode);
	    int count = list.size();

	    Map<String, Object> response = new LinkedHashMap<>();
	    
	    // Prepare response with count of centers found and the data
	    response.put("count", count);
	    response.put("data", list);
	    
	    // If no centers found, return a not found status; otherwise, return the response
	    if (count == 0) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    } else {
	    	return ResponseEntity.ok(response);
	    }
	}
}
