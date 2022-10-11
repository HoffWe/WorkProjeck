package com.example.workproject.dto;

import com.example.workproject.model.Message;
import com.example.workproject.model.Worker;


import java.time.LocalDateTime;

public class TaskDtoIn {


    private String title;
    private long messageId;
    private long executorId;
    private LocalDateTime finishDate;

}
