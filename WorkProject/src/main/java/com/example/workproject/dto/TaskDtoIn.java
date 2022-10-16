package com.example.workproject.dto;

import com.example.workproject.model.Message;
import com.example.workproject.model.Worker;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
@Data
@Builder
public class TaskDtoIn {

    @NotNull
    @Length(max = 200)
    private String title;
    @NotNull
    @Pattern(regexp = "^[0-9]")
    private long messageId;
    @NotNull
    @Pattern(regexp = "^[0-9]")
    private long executorId;
    @NotNull
    private LocalDateTime finishDate;

}
