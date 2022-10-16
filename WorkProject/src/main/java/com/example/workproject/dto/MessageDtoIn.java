package com.example.workproject.dto;


import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class MessageDtoIn {

    @NotNull
    @Length(max = 200)
    private String title;
    @NotNull
    @Pattern(regexp = "^[0-9]")
    private long recipientId;
    @NotNull
    @Pattern(regexp = "^[0-9]")
    private long senderId;
    @NotNull
    @Length(max = 2000)
    private String content;
}
