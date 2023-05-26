package com.example.taskmanager.serviceImpl;

import com.example.taskmanager.DTO.TaskDTO;
import com.example.taskmanager.DTO.mapper.TaskMapper;
import com.example.taskmanager.constants.TaskConstants;
import com.example.taskmanager.dao.TaskDao;
import com.example.taskmanager.entities.Task;
import com.example.taskmanager.exception.RecordNotFoundException;
import com.example.taskmanager.service.TaskService;
import com.example.taskmanager.utils.DateUtils;
import com.example.taskmanager.utils.Taskutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskDao dao;

    @Autowired
    TaskMapper mapper;

    @Override
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        List<TaskDTO> tasks = dao.findAll().stream().map(mapper::toDTO).toList();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> createTask(TaskDTO dto) throws ParseException {
        dto.setCreationDate(DateUtils.formatDateToString(new Date()));
        dao.save(mapper.toEntity(dto));
        return new ResponseEntity<>(TaskConstants.TASK_ADDED_SUCCESSFULLY, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updateTask(Long id, TaskDTO dto) {
        Task task = dao.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(Taskutils.convertStatusValue(dto.getStatus()));
        dao.save(task);
        return new ResponseEntity<>(TaskConstants.TASK_UPDATED_SUCCESSFULLY, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteTask(Long id) {
        dao.delete(dao.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
        return new ResponseEntity<>(TaskConstants.TASK_DELETED_SUCCESSFULLY, HttpStatus.OK);
    }
}
