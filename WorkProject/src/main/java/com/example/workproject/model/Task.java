package com.example.workproject.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @OneToOne
    private Message message;
    @OneToOne
    private Worker executor;
    private LocalDateTime finishDate;
    private LocalDateTime issueDate;
    private boolean isFinished;

}
