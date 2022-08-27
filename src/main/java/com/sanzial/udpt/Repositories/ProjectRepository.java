package com.sanzial.udpt.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanzial.udpt.Entitiy.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
