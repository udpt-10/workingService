package com.sanzial.udpt.Entitiy;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projectemployee")
public class ProjectEmp {
    @Id
    @Column(name = "project_emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectEmpId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "number_of_day")
    private int numberOfDay;

    @Column(name = "employee_id")
    private int employeeId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project projectOf;
}