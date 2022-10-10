package com.example.workproject.mapper;

import com.example.workproject.dto.WorkerDtoOut;
import com.example.workproject.model.Worker;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkerToDto {

   public static WorkerDtoOut mapToDto(Worker worker){
        return WorkerDtoOut.builder()
                .id(worker.getId())
                .name(worker.getName())
                .lastName(worker.getLastName())
                .build();
    }
}
