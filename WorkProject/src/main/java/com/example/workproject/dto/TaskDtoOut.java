package com.example.workproject.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskDtoOut {

    private long id;
    private String title;
    private MessageDtoOut message;
    private WorkerDtoOut executor;
    private LocalDateTime finishDate;
    private LocalDateTime issueDate;
    private boolean isFinished;
}
