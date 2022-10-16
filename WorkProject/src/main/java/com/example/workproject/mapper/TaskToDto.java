package com.example.workproject.mapper;

import com.example.workproject.dto.MessageDtoOut;
import com.example.workproject.dto.TaskDtoOut;
import com.example.workproject.dto.WorkerDtoOut;
import com.example.workproject.model.Task;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TaskToDto {

   public static TaskDtoOut mapToDto(Task task) {
        return TaskDtoOut.builder()
                .id(task.getId())
                .title(task.getTitle())
                .message(MessageDtoOut.builder()
                        .title(task.getMessage().getTitle())
                        .content(task.getMessage().getContent())
                        .sender(WorkerDtoOut.builder()
                                .id(task.getMessage().getSender().getId())
                                .name(task.getMessage().getSender().getName())
                                .lastName((task.getMessage().getSender().getLastName()))
                                .build())
                        .recipient(WorkerDtoOut.builder()
                                .id(task.getMessage().getRecipient().getId())
                                .name(task.getMessage().getRecipient().getName())
                                .lastName(task.getMessage().getRecipient().getLastName())
                                .build())
                        .issueDate(task.getMessage().getIssueDate())
                        .build())
                .executor(WorkerDtoOut.builder()
                        .id(task.getExecutor().getId())
                        .name(task.getExecutor().getName())
                        .lastName(task.getExecutor().getLastName())
                        .build())
                .issueDate(task.getIssueDate())
                .finishDate(task.getDeadLine())
                .isFinished(task.isFinished())
                .build();

    }
}