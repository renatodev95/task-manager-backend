package com.example.taskmanager.entities;

import com.example.taskmanager.enums.Status;
import com.example.taskmanager.enums.converter.StatusConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String title;

    @NotNull
    @NotBlank
    @Column(length = 100, nullable = false)
    private String description;

    private Date creationDate;

    private Date conclusionDate;

    @Convert(converter = StatusConverter.class)
    private Status status;
}
