package com.example.workproject.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne (targetEntity = Worker.class,fetch = FetchType.EAGER, optional = false)
    private Worker recipient;
    @ManyToOne(targetEntity = Worker.class, fetch = FetchType.EAGER, optional = false)
    private Worker sender;
    private String content;
    private String title;
    private LocalDateTime issueDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Message message = (Message) o;
        return id != null && Objects.equals(id, message.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
