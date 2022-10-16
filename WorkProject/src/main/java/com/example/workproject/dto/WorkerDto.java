package com.example.workproject.dto;


import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class WorkerDto {

    @NotNull
    @Pattern(regexp = "[A-Za-z0-9'.\\-\\s,]")
    @Length (min = 2)
    private String name;
    @NotNull
    @Pattern(regexp = "[A-Za-z0-9'.\\-\\s,]")
    @Length (min = 2)
    private String lastName;
    @NotNull
    @Email
    private String eMail;
    @NotNull
    @Length(min = 5, max = 20)
    private String password;

}
