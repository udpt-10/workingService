package com.sanzial.udpt.Services.impl;

import java.util.List;
import java.util.Optional;
import java.time.temporal.ChronoUnit;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sanzial.udpt.DTO.Request.ProjectEmpRequest;
import com.sanzial.udpt.Entitiy.Project;
import com.sanzial.udpt.Entitiy.ProjectEmp;
import com.sanzial.udpt.Exeptions.BadRequestExeption;
import com.sanzial.udpt.Exeptions.NotFoundExeption;
import com.sanzial.udpt.Repositories.ProjectEmpRepository;
import com.sanzial.udpt.Repositories.ProjectRepository;
import com.sanzial.udpt.Services.ProjectEmpService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectEmpServiceImpl implements ProjectEmpService {
    private final ProjectEmpRepository projectEmpRepository;
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ProjectEmp> getProjectEmpsByProjectId(int id) {
        if (projectEmpRepository.findAllByProjectId(id).isEmpty())
            throw new NotFoundExeption("No employee in project with id " + id);

        return projectEmpRepository.findAllByProjectId(id);
    }

    @Override
    public List<ProjectEmp> getProjectEmpsByEmpId(int id) {
        if (projectEmpRepository.findAllByEmpId(id).isEmpty())
            throw new NotFoundExeption("No project with employee id " + id);

        return projectEmpRepository.findAllByEmpId(id);
    }

    @Override
    public ProjectEmp createNewProjectEmp(ProjectEmpRequest projectEmp) {
        Optional<Project> project = projectRepository.findById(projectEmp.getProjectId());

        if (project.isEmpty())
            throw new BadRequestExeption("Not found project with id " + projectEmp.getProjectId());

        ProjectEmp newProjectEmp = modelMapper.map(projectEmp, ProjectEmp.class);

        newProjectEmp.setProjectOf(project.get());
        newProjectEmp.setNumberOfDay((int) ChronoUnit.DAYS.between(projectEmp.getStartDate(), projectEmp.getEndDate()));

        return projectEmpRepository.save(newProjectEmp);
    }

    @Override
    public void deleteProjectEmp(int id) {
        if (projectEmpRepository.findById(id).isEmpty())
            throw new NotFoundExeption("Not found with id " + id);

        projectEmpRepository.deleteById(id);
    }
}
