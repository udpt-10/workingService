package com.sanzial.udpt.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sanzial.udpt.Entitiy.Project;

@Service
public interface ProjectService {
    Project showProject(int id);

    List<Project> showOldProject();

    Project createProject(Project newProject);
}
