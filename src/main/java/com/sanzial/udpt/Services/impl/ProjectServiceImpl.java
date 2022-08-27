package com.sanzial.udpt.Services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sanzial.udpt.Entitiy.Project;
import com.sanzial.udpt.Exeptions.NotFoundExeption;
import com.sanzial.udpt.Repositories.ProjectRepository;
import com.sanzial.udpt.Services.ProjectService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Override
    public Project showProject(int id) {
        if (projectRepository.findById(id).isEmpty())
            throw new NotFoundExeption("Project not found with id: " + id);

        return projectRepository.findById(id).get();
    }

    @Override
    public List<Project> showOldProject() {

        return projectRepository.findAll();
    }

    @Override
    public Project createProject(Project newProject) {

        return projectRepository.save(newProject);
    }
}
