package com.example.taskmanager.enums;

public enum Status {

    IN_PROGRESS("Andamento"),
    CONCLUDED("Concluido");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
