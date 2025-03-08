package com.traini8.entities;

import java.time.Instant;
import java.util.List;

import com.traini8.validation.ValidPhoneNumber;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "TrainingCenters")
public class TrainingCenter {
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "center_id")
    private int id;

    @NotEmpty(message="centerName cann't be empty or null")
    @Size(max = 40, message = "CenterName must be maximum of 40 characters !!")
    private String centerName;

    @NotEmpty(message="centerCode cann't be empty or null")
    @Size(max = 12, min = 12, message = "CenterCode must be exactly 12 character alphanumeric !!")
    private String centerCode;

   
    @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "Student capacity must contain only digits")
    private long studentCapacity;

    private List<String> coursesOffered;
    private String createdOn;
    
    // Automatically set the creation date before persisting
    @PrePersist
    private void onCreated() {
    	createdOn = Long.toString(Instant.now().toEpochMilli());
    }
    
    @Email(message = "Please enter a valid Email !!")
    private String contactEmail;

    @ValidPhoneNumber(message = "Invalid phone number. Phone number must have exact 10 digits.")
    private long contactPhone;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    
    // Getters and setters for the TrainingCenter fields
//    public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getCenterName() {
//		return centerName;
//	}
//
//	public void setCenterName(String centerName) {
//		this.centerName = centerName;
//	}
//
//	public String getCenterCode() {
//		return centerCode;
//	}
//
//	public void setCenterCode(String centerCode) {
//		this.centerCode = centerCode;
//	}
//
//	public long getStudentCapacity() {
//		return studentCapacity;
//	}
//
//	public void setStudentCapacity(long studentCapacity) {
//		this.studentCapacity = studentCapacity;
//	}
//
//	public List<String> getCoursesOffered() {
//		return coursesOffered;
//	}
//
//	public void setCoursesOffered(List<String> coursesOffered) {
//		this.coursesOffered = coursesOffered;
//	}
//
//	public String getCreatedOn() {
//		return createdOn;
//	}
//
//	public void setCreatedOn(String createdOn) {
//		this.createdOn = createdOn;
//	}
//
//	public String getContactEmail() {
//		return contactEmail;
//	}
//
//	public void setContactEmail(String contactEmail) {
//		this.contactEmail = contactEmail;
//	}
//
//	public long getContactPhone() {
//		return contactPhone;
//	}
//
//	public void setContactPhone(long contactPhone) {
//		this.contactPhone = contactPhone;
//	}
//
//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}
//
//	
//	// Constructors for the TrainingCenter class
//	public TrainingCenter(int id,
//			@NotEmpty @Size(max = 40, message = "CenterName must be maximum of 40 characters !!") String centerName,
//			@NotEmpty @Size(max = 12, min = 12, message = "CenterCode must be exactly 12 character alphanumeric !!") String centerCode,
//			@Digits(integer = 2147483647, fraction = 0, message = "Student capacity must contain only digits") long studentCapacity,
//			List<String> coursesOffered, String createdOn,
//			@Email(message = "Please enter a valid Email !!") String contactEmail, long contactPhone, Address address) {
//		super();
//		this.id = id;
//		this.centerName = centerName;
//		this.centerCode = centerCode;
//		this.studentCapacity = studentCapacity;
//		this.coursesOffered = coursesOffered;
//		this.createdOn = createdOn;
//		this.contactEmail = contactEmail;
//		this.contactPhone = contactPhone;
//		this.address = address;
//	}
//
//	
//	// Default constructor
//	public TrainingCenter() {
//		super();
//	}
//	
//	
//	// Override toString method for TrainingCenter class
//	@Override
//	public String toString() {
//		return "TrainingCenter [id=" + id + ", centerName=" + centerName + ", centerCode=" + centerCode
//				+ ", studentCapacity=" + studentCapacity + ", coursesOffered=" + coursesOffered + ", createdOn="
//				+ createdOn + ", contactEmail=" + contactEmail + ", contactPhone=" + contactPhone + ", address="
//				+ address + "]";
//	}    
}
