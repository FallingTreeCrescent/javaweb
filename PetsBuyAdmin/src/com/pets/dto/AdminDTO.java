package com.pets.dto;

import java.util.List;

public class AdminDTO {
	private String name ;
	private String email;
    private Boolean isDeleted;
	
	private String password;
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	private Long Id;

	public String getPhone() {
		return phone;
	}
	@Override
	public String toString() {
		return "AdminDTO [name=" + name + ", email=" + email + ", password=" + password + ", Id=" + Id + ", phone="
				+ phone + "]";
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	private String phone;
	
//	private List<Long> number;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	
	

}
