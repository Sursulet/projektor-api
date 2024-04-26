package com.projektor.service;

import com.projektor.entity.Project;
import com.projektor.entity.User;
import com.projektor.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(true)
public class ProjectServiceTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectService projectService;

    // Test to create a project
    @Test
    public void testCreateProject() {
        // Create an existing user (simulated)
        User author = userRepository.findById(1).get();

        // Create a project with all attributes
        Project project = new Project();
        project.setDescription("Project description");
        project.setDeadline(LocalDate.now().plusDays(30));
        project.setPriority(1);
        project.setStatus("in progress");
        project.setTitle("rrrrrrrrrrrrrrrrrrr");
        project.setAuthor(author); // Existing user
        project.setStartDate(LocalDateTime.now());
        project.setEndDate(LocalDateTime.now().plusDays(30)); // Can be null for now

        // Save the project
        Project createdProject = projectService.saveProject(project);

        // Verify that the project was created successfully
        assertThat(createdProject).isNotNull();
        assertThat(createdProject.getId()).isNotNull();
        assertThat(createdProject.getDescription()).isEqualTo("Project description");
        // Other assertions for other attributes...
    }



    // Test to update a project
    @Test
    public void testUpdateProject() {
        // Retrieve an existing project from the database (simulated)
        int existingProjectId = 1; // ID of an existing project
        Project existingProject = projectService.getProjectById(existingProjectId);
        assertThat(existingProject).isNotNull();

        // Modify the project
        existingProject.setDescription("New project description");

        // Save the modifications to the project
        Project updatedProject = projectService.saveProject(existingProject);

        // Verify that the project was updated successfully
        assertNotNull(updatedProject);
        assertThat(updatedProject.getId()).isEqualTo(existingProjectId);
        assertThat(updatedProject.getDescription()).isEqualTo("New project description");
        // Other assertions for other attributes...

    }

    // test to retrieve all projects
    @Test
    public void testGetAllProjects() {
        // Act
        List<Project> allProjects = projectService.getAllProjects();

        /* Assert */
        assertNotNull(allProjects);
        assertEquals(7, allProjects.size()); // Assuming there are 7 projects in the seed data

        // You can add more assertions to verify the contents of the list
    }



    //test to save a project
    @Test
    public void testSaveProject() {
        // testing datas
        User author = userRepository.findById(1).get();
        Project project = new Project();
        project.setTitle("Titre du projet");
        project.setDeadline(LocalDate.now());
        project.setPriority(3);
        project.setStatus("in progress");
        project.setDescription("Description du projet");
        project.setAuthor(author);

        // calling the method to test
        Project savedProject = projectService.saveProject(project);

        // verifying if writing is succesful
        assertEquals("Titre du projet", savedProject.getTitle());
        assertEquals("Description du projet", savedProject.getDescription());
        assertEquals(author.getId(), savedProject.getAuthor().getId());
    }

    private static User getProjectRepository() {
        return null;
    }

}