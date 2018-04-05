package com.karint.domain;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Race implements Serializable{
	private static final long serialVersionUID = -2885437690668497312L;

	@Column
	private String name;

	@Column
	private String gender;

	@Id
	@Access(AccessType.PROPERTY)
	public String getCompositeKey(){
		return this.name+this.gender;
	}
}
