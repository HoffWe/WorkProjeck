package com.example.workproject.model;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Worker implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String eMail;
    private String password;
    private String role;
    private boolean enabled;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        final String[] roleArray = role.split(" ");
        for (String role: roleArray){
            authorities.add(()-> role);
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return eMail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
