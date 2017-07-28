package com.cooksys.dto;

import java.util.Set;

import com.cooksys.dto.datatype.Reference;
import com.cooksys.entity.Project;

public class ProjectManagerWithOverdueDto {
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private Set<Reference<Project, Long>> projects;
	
	private Long overdue;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the projects
	 */
	public Set<Reference<Project, Long>> getProjects() {
		return projects;
	}

	/**
	 * @param projects the projects to set
	 */
	public void setProjects(Set<Reference<Project, Long>> projects) {
		this.projects = projects;
	}

	/**
	 * @return the overdue
	 */
	public Long getOverdue() {
		return overdue;
	}

	/**
	 * @param overdue the overdue to set
	 */
	public void setOverdue(Long overdue) {
		this.overdue = overdue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectManagerWithOverdueDto other = (ProjectManagerWithOverdueDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
