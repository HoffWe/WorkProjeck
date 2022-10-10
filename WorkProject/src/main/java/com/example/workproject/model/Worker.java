package com.example.workproject.model;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String eMail;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;

        if (!id.equals(worker.id)) return false;
        if (!name.equals(worker.name)) return false;
        if (!lastName.equals(worker.lastName)) return false;
        if (!eMail.equals(worker.eMail)) return false;
        return password.equals(worker.password);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + eMail.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
