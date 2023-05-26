package com.example.taskmanager.service;

import com.example.taskmanager.DTO.TaskDTO;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;

public interface TaskService {

    ResponseEntity<List<TaskDTO>> getAllTasks();

    ResponseEntity<String> createTask(TaskDTO dto) throws ParseException;

    ResponseEntity<String> updateTask(Long id, TaskDTO dto);
}
