package com.india.icicibank.dto;

import java.time.LocalDate;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
public class CustomerRegistrationDto {
	@NotEmpty(message = "fristName should not be empty")
	@Size(min = 3, max = 20,message = " fristName should less then 20 character only")
	private String fristName;
	@NotEmpty(message = "lastName should not be empty")
	@Size(min = 3, max = 20,message = "lastName should less then 20 character only")
	private String lastName;
	@NotEmpty(message = "emailId should not be empty")
	@Email
	@Size(min = 5, max = 100,message = "EmailId size should should be 100 characterstics only")
	private String emailid;
	@NotEmpty(message = "Please provide a Mobile Number")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Provide valid Mobile Number")
	@Size(min = 5, max = 10, message = "phone number is of 10 digits")
	private String phoneNumber;
	@NotEmpty(message = "gendar should not be empty")
	@Size(min = 4, max = 10,message = "employee gender should by 1 character only")
	private String gendar;
	@NotEmpty(message = "pannumber should not be empty")
	@Size(min = 8, max = 20,message = " pannumber should less then 20 character only")
	private String pannumber;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message="please provide date")
	private LocalDate dob;
	@Min(18)
	private int age;
	@NotEmpty(message = "address should not be empty")
	@Size(min = 3, max = 100,message = " address should less then 100 character only")
	private String address;
	//private long customerId;
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getGendar() {
		return gendar;
	}
	public void setGendar(String gendar) {
		this.gendar = gendar;
	}
	public String getPannumber() {
		return pannumber;
	}
	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}
//	public long getCustomerId() {
//		return customerId;
//	}
//	public void setCustomerId(long customerId) {
//		this.customerId = customerId;
//	}
//	
	

}
