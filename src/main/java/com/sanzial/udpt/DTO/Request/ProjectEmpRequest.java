package com.sanzial.udpt.DTO.Request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectEmpRequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private int employeeId;
    private int projectId;
}