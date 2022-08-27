package com.sanzial.udpt.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sanzial.udpt.Entitiy.ProjectEmp;

@Repository
public interface ProjectEmpRepository extends JpaRepository<ProjectEmp, Integer> {
    @Query(value = "SELECT *FROM projectemployee p WHERE project_id = :id", nativeQuery = true)
    List<ProjectEmp> findAllByProjectId(@Param("id") int id);

    @Query(value = "SELECT *FROM projectemployee p WHERE employee_id  = :id", nativeQuery = true)
    List<ProjectEmp> findAllByEmpId(@Param("id") int id);
}
