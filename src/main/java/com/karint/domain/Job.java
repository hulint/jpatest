package com.karint.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.google.common.collect.Lists;

import lombok.Data;

@Entity
@Data
public class Job implements Serializable{
	private static final long serialVersionUID = -1799595666141836095L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column
	private String name;

	@OneToMany
	@JoinTable(name="job_skills")
	private List<Skill> Skills = Lists.newArrayList();
}
