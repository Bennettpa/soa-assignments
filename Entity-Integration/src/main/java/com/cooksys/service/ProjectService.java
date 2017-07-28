package com.cooksys.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cooksys.dto.ProjectDto;
import com.cooksys.entity.Project;
import com.cooksys.entity.ProjectManager;
import com.cooksys.exception.ReferencedEntityNotFoundException;
import com.cooksys.mapper.ProjectManagerMapper;
import com.cooksys.mapper.ProjectMapper;
import com.cooksys.repository.ProjectManagerRepository;
import com.cooksys.repository.ProjectRepository;

@Service
public class ProjectService {

	private ProjectRepository repo;
	private ProjectMapper mapper;
	private ProjectManagerRepository mrepo;
	private ProjectManagerMapper mmapper;
	
	public ProjectService(ProjectRepository repo, ProjectMapper mapper, ProjectManagerRepository mrepo,
			ProjectManagerMapper mmapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
		this.mrepo = mrepo;
		this.mmapper = mmapper;
	}

	public List<ProjectDto> getAll() {
		return repo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
	}

	public boolean has(Long id) {
		return repo.exists(id);
	}

	public ProjectDto get(Long id) {
		mustExist(id);
		return mapper.toDto(repo.findOne(id));
	}

	public Long post(ProjectDto projectDto) {
		projectDto.setId(null);
		return repo.save(mapper.toEntity(projectDto)).getId();
	}

	public void put(Long id, ProjectDto projectDto) {
		mustExist(id);
		projectDto.setId(id);
		repo.save(mapper.toEntity(projectDto));
	}
	
	private void mustExist(Long id) {
		if(!has(id))
			throw new ReferencedEntityNotFoundException(Project.class, id);
	}

	public void delete(Long id) {
		mustExist(id);
		repo.delete(id);
	}

	public List<ProjectDto> getOverdueAll() {
		return repo.findAll().stream().filter(item -> item.getEndDate().toLocalDate().compareTo(LocalDate.now())<0).map(mapper::toDto).collect(Collectors.toList());
	}

	public void addManager(long projectId, long managerId) {
		Project project = repo.getOne(projectId);
		ProjectManager manager = mrepo.getOne(managerId);
		project.setManager(manager);
		repo.save(project);
		
	}
}