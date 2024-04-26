package com.projektor.repository;

import com.projektor.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    // Method to retrieve projects by client
    List<Project> findByAuthorId(Integer clientId) ;

    // Method to retrieve projects by status
    List<Project> findByStatus(String status);

    // Method to retrieve projects by title containing a keyword
    List<Project> findByTitleContaining(String keyword);

    // Method to retrieve projects by description containing a keyword
    List<Project> findByDescriptionContaining(String keyword);

    // Method to retrieve projects by client and title containing a keyword
    List<Project> findByAuthorIdAndTitleContaining(Integer clientId, String keyword);

    // Method to retrieve projects by client and description containing a keyword
    List<Project> findByAuthorIdAndDescriptionContaining(Integer clientId, String keyword);

    List<Project> findByAuthorIdAndStatus(Integer clientId, String status);
}
