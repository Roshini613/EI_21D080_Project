package com.classroom.model;

import java.time.LocalDate;

public class Assignment {
    private String details;
    private LocalDate deadline;

    public Assignment(String details, LocalDate deadline) {
        this.details = details;
        this.deadline = deadline;
    }

    public LocalDate getDeadline() {
        return deadline;
    }
}
