package com.erthocodeur.fleetapp.models;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EmployeeType extends CommonObject {


	public EmployeeType() {
	}

	public EmployeeType(Integer id, String description, String details) {
		super(id, description, details);
		// TODO Auto-generated constructor stub
	}
	

}
