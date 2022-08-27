package com.sanzial.udpt.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sanzial.udpt.DTO.Request.ProjectEmpRequest;
import com.sanzial.udpt.Entitiy.ProjectEmp;

@Service
public interface ProjectEmpService {
    List<ProjectEmp> getProjectEmpsByProjectId(int id);

    List<ProjectEmp> getProjectEmpsByEmpId(int id);

    ProjectEmp createNewProjectEmp(ProjectEmpRequest projectEmp);

    void deleteProjectEmp(int id);
}
