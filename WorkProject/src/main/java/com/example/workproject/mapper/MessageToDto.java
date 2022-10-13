package com.example.workproject.mapper;

import com.example.workproject.dto.MessageDtoOut;
import com.example.workproject.dto.WorkerDtoOut;
import com.example.workproject.model.Message;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageToDto {

    public static MessageDtoOut mapToDto(Message message){
        return MessageDtoOut.builder()
                .id(message.getId())
                .title(message.getTitle())
                .content(message.getContent())
                .recipient(WorkerDtoOut.builder()
                        .id(message.getRecipient().getId())
                        .name(message.getRecipient().getName())
                        .lastName(message.getRecipient().getLastName())
                        .build())
                .sender(WorkerDtoOut.builder()
                        .id(message.getSender().getId())
                        .name(message.getSender().getName())
                        .lastName(message.getSender().getLastName())
                        .build())
                .issueDate(message.getIssueDate())
                .build();
    }
}

