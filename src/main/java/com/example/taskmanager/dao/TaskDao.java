package com.example.taskmanager.dao;

import com.example.taskmanager.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository<Task, Long> {

}
