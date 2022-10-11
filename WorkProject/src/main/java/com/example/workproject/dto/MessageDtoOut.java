package com.example.workproject.dto;

import com.example.workproject.model.Worker;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MessageDtoOut {

    private long id;
    private String title;
    private String content;
    private WorkerDtoOut recipient;
    private WorkerDtoOut sender;
    private LocalDateTime issueDate;

}
