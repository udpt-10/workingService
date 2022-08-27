package com.sanzial.udpt.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sanzial.udpt.Entitiy.Project;
import com.sanzial.udpt.Services.ProjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Project getProjectById(@PathVariable int id) {
        return projectService.showProject(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Project> getAllProject() {
        return projectService.showOldProject();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project createNewProject(@RequestBody Project newProject) {
        return projectService.createProject(newProject);
    }

}
