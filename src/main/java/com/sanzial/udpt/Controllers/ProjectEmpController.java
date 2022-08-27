package com.sanzial.udpt.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sanzial.udpt.DTO.Request.ProjectEmpRequest;
import com.sanzial.udpt.Entitiy.ProjectEmp;
import com.sanzial.udpt.Services.ProjectEmpService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/projectEmp")
@RequiredArgsConstructor
public class ProjectEmpController {
    private final ProjectEmpService projectEmpService;

    @GetMapping("/projectId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectEmp> getProjectEmpsByProjectId(@PathVariable int id) {
        return projectEmpService.getProjectEmpsByProjectId(id);
    }

    @GetMapping("/empId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectEmp> getProjectEmpsByEmpId(@PathVariable int id) {
        return projectEmpService.getProjectEmpsByEmpId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectEmp createNewProjectEmp(@RequestBody ProjectEmpRequest newProjectEmp) {
        return projectEmpService.createNewProjectEmp(newProjectEmp);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteProjectEmp(@PathVariable int id) {
        projectEmpService.deleteProjectEmp(id);
    }
}
