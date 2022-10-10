package com.example.workproject.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkerDto {

    private String name;
    private String lastName;
    private String eMail;
    private String password;

}
