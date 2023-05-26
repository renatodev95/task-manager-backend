package com.example.taskmanager.restImpl;

import com.example.taskmanager.DTO.TaskDTO;
import com.example.taskmanager.constants.TaskConstants;
import com.example.taskmanager.rest.TaskRest;
import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskRestImpl implements TaskRest {

    @Autowired
    TaskService service;


    @Override
    public ResponseEntity<String> createTask(@RequestBody TaskDTO dto) {
        try {
            return service.createTask(dto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(TaskConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        try {
            return service.getAllTasks();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> updateTask(Long id, TaskDTO dto) {
        try {
            return service.updateTask(id, dto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(TaskConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
