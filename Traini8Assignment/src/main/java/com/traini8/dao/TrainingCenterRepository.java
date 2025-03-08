package com.traini8.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traini8.entities.TrainingCenter;

@Repository
public interface TrainingCenterRepository extends CrudRepository<TrainingCenter, Integer> {
    // Custom query to search for training centers with optional parameters
    @Query("SELECT t FROM TrainingCenter t " +
               "LEFT JOIN FETCH t.address a " + // Join with Address table
               "WHERE " +
               "(:centerName is null or t.centerName like %:centerName%) " +
               "and (:centerCode is null or t.centerCode = :centerCode) " +
               "and (:studentCapacity is null or t.studentCapacity = :studentCapacity) " +
               "and (:coursesOffered is null or t.coursesOffered IN :coursesOffered) " +
               "and (:contactEmail is null or t.contactEmail = :contactEmail) " +
               "and (:contactPhone is null or t.contactPhone = :contactPhone) " +
               "and (:createdOn is null or t.createdOn = :createdOn) " +
               // Only add address conditions if data from Address table is requested
               "and (:city is null or a.city = :city) " +
               "and (:pincode is null or a.pincode = :pincode)"+
               "and (:state is null or a.state = :state)"
               )
    // Method to search for training centers based on various criteria
    List<TrainingCenter> searchCenters(@Param("centerName") String centerName,
                                       @Param("centerCode") String centerCode,
                                       @Param("studentCapacity") Long studentCapacity,
                                       @Param("coursesOffered") List<String> coursesOffered,
                                       @Param("contactEmail") String contactEmail,
                                       @Param("contactPhone") Long contactPhone,
                                       @Param("createdOn") String createdOn,
                                       @Param("city") String city,
                                       @Param("state") String state,
                                       @Param("pincode") Long pincode);
}
