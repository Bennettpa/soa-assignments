package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
