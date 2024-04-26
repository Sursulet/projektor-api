package com.projektor.service;


import com.projektor.entity.Project;
import com.projektor.entity.User;
import com.projektor.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    private Object userRepository;

    // Method to save a project
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    // Method to retrieve all projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Method to retrieve projects by client ID
    public List<Project> getProjectsByClientId(Integer clientId) {
        return projectRepository.findByAuthorId(clientId);
    }

    // Method to retrieve projects by status
    public List<Project> getProjectsByStatus(String status) {
        return projectRepository.findByStatus(status);
    }

    // Method to retrieve projects by client ID and status
    public List<Project> getProjectsByClientIdAndStatus(Integer clientId, String status) {
        return projectRepository.findByAuthorIdAndStatus(clientId, status);
    }

    // Method to retrieve projects by keyword in title
    public List<Project> searchProjectsByTitle(String keyword) {
        return projectRepository.findByTitleContaining(keyword);
    }

    // Method to retrieve projects by keyword in description
    public List<Project> searchProjectsByDescription(String keyword) {
        return projectRepository.findByDescriptionContaining(keyword);
    }

    // Method to retrieve projects by client ID and keyword in title
    public List<Project> searchProjectsByClientIdAndTitle(Integer clientId, String keyword) {
        return projectRepository.findByAuthorIdAndTitleContaining(clientId, keyword);
    }

    // Method to retrieve projects by client ID and keyword in description
    public List<Project> searchProjectsByClientIdAndDescription(Integer clientId, String keyword) {
        return projectRepository.findByAuthorIdAndDescriptionContaining(clientId, keyword);
    }

    public Project getProjectById(long existingProjectId) {
        return projectRepository.findById(existingProjectId).get();
    }
}
