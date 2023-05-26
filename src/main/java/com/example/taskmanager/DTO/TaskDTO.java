package com.example.taskmanager.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TaskDTO {

    private Long id;
    private String title;
    private String description;
    private String creationDate;
    private String conclusionDate;
    private String status;

    public TaskDTO(Long id, String title, String description, String creationDate, String conclusionDate, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.conclusionDate = conclusionDate;
        this.status = status;
    }
}
