package com.example.workproject.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDtoIn {

    private String title;
    private long recipientId;
    private String content;
}
