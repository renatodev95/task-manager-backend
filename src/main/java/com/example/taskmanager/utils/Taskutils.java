package com.example.taskmanager.utils;

import com.example.taskmanager.enums.Status;

public class Taskutils {

    public static Status convertStatusValue(String value) {
        if (value == null) {
            return null;
        }

        return switch (value) {
            case "Em andamento" -> Status.IN_PROGRESS;
            case "Finalizada" -> Status.CONCLUDED;
            default -> throw new IllegalArgumentException("Status inválido: " + value);
        };
    }
}
