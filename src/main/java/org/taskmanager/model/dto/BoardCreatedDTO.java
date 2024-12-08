package org.taskmanager.model.dto;

import lombok.Data;

@Data
public class BoardCreatedDTO {
    private String name;
    private String department;
    private String type;
    private Long headOfDepartmentId;
}
