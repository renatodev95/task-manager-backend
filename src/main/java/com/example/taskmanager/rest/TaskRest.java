package com.example.taskmanager.rest;

import com.example.taskmanager.DTO.TaskDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/task")
public interface TaskRest {

    @PostMapping(path = "/create")
    ResponseEntity<String> createTask(@RequestBody TaskDTO dto);

    @GetMapping(path = "/get")
    ResponseEntity<List<TaskDTO>> getAllTasks();

    @PutMapping(path = "/update/{id}")
    ResponseEntity<String> updateTask(@PathVariable @NotNull @Positive Long id, @RequestBody TaskDTO dto);
}
