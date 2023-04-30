package com.maha.firstspringproject;



import java.time.LocalDate;
import java.util.Objects;

import org.hibernate.annotations.GeneratorType;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
	
	private String emailId;
	
	private String name;
	
	private LocalDate dateofBirth;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(LocalDate dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, dateofBirth, emailId, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customers other = (Customers) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(dateofBirth, other.dateofBirth)
				&& Objects.equals(emailId, other.emailId) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", emailId=" + emailId + ", name=" + name + ", dateofBirth="
				+ dateofBirth + "]";
	}
	
	

}
