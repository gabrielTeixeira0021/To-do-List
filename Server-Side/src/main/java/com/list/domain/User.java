package com.list.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

    public User (String username, String email) {
        this.username = username;
        this.email = email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email);
    }

    @Override
    public String toString() {
        return "User {id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email=" + email + '\'' +
                "}";

    }
}
