package com.example.taskmanager.DTO.mapper;

import com.example.taskmanager.DTO.TaskDTO;
import com.example.taskmanager.entities.Task;
import com.example.taskmanager.utils.DateUtils;
import com.example.taskmanager.utils.Taskutils;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class TaskMapper {

    public TaskDTO toDTO(Task task) {
        if (task == null) {
            return null;
        }
        return TaskDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .creationDate(DateUtils.formatDateToString(task.getCreationDate()))
                .conclusionDate(DateUtils.formatDateToString(task.getConclusionDate()))
                .status(task.getStatus().getValue())
                .build();
    }

    public Task toEntity(TaskDTO dto) throws ParseException {
        if (dto == null) {
            return null;
        }

        Task task = new Task();
        if (dto.getId() != null) {
            task.setId(dto.getId());
        }

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCreationDate(DateUtils.parseDate(dto.getCreationDate()));
        task.setConclusionDate(DateUtils.parseDate(dto.getConclusionDate()));
        task.setStatus(Taskutils.convertStatusValue(dto.getStatus()));
        return task;
    }

}
