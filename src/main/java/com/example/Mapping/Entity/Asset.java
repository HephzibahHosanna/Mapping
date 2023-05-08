package com.example.Mapping.Entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "assets")
public class Asset {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name",nullable = false,unique = true)
	@NotBlank(message="asset name should not be blank")
	private String name;
	
	@CreationTimestamp
	private Date createdAt;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "c_id")
	private Category category;
	
	//Generated Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	//default constructor
	public Asset() {
		
	}
	
	//Generating parameterized Constructors using fields
		public Asset(String name,Category category, Date createdAt) {
			super();
			this.name = name;
			this.category = category;
			this.createdAt = createdAt;
		}
}

