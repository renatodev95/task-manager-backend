package com.example.taskmanager;

import com.example.taskmanager.enums.Status;
import com.example.taskmanager.dao.TaskDao;
import com.example.taskmanager.entities.Task;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class TaskManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(TaskDao dao) {
		return args -> {
			dao.deleteAll();
			Task t = new Task();
			t.setTitle("Titulo 1");
			t.setDescription("Executar tarefa 1");
			t.setCreationDate(new Date());
			t.setStatus(Status.IN_PROGRESS);
			dao.save(t);
		};
	}
}
