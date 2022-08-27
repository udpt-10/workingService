package com.sanzial.udpt.Entitiy;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
public class Project {
    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;

    @Column(name = "manager_id", nullable = false)
    private int manageId;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "type", length = 50)
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "projectOf")
    private Set<ProjectEmp> projectEmpsSet;
}