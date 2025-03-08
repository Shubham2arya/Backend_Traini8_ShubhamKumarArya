package com.traini8.entities;

import com.traini8.validation.ValidPincode;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressId;
	
	@NotEmpty(message = "Detailed address should not be empty")
	private String detailedAddress;
	
	@NotEmpty(message = "City should not be empty")
	private String city;
	
	@NotEmpty(message = "State should not be empty")
	private String state;
	
    @Positive(message = "Pincode must be a positive number")
    @ValidPincode
	private long pincode;
	
    // Getters and setters for the Address fields
//	public int getAddressId() {
//		return addressId;
//	}
//	public void setAddressId(int addressId) {
//		this.addressId = addressId;
//	}
//	public String getDetailedAddress() {
//		return detailedAddress;
//	}
//	public void setDetailedAddress(String detailedAddress) {
//		this.detailedAddress = detailedAddress;
//	}
//	public String getCity() {
//		return city;
//	}
//	public void setCity(String city) {
//		this.city = city;
//	}
//	public String getState() {
//		return state;
//	}
//	public void setState(String state) {
//		this.state = state;
//	}
//	public long getPincode() {
//		return pincode;
//	}
//	public void setPincode(long pincode) {
//		this.pincode = pincode;
//	}
//	
//	// AllArgsConstructors for the Address class
//	public Address(int addressId, String detailedAddress, String city, String state, long pincode) {
//		super();
//		this.addressId = addressId;
//		this.detailedAddress = detailedAddress;
//		this.city = city;
//		this.state = state;
//		this.pincode = pincode;
//	}
//	
//	// Default constructor
//	public Address() {
//		super();
//	}
//	
//	
//	// Override toString method for Address class
//	@Override
//	public String toString() {
//		return "Address [addressId=" + addressId + ", detailedAddress=" + detailedAddress + ", city=" + city
//				+ ", state=" + state + ", pincode=" + pincode + "]";
//	}
}
