package com.example.repositories;


import com.example.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
