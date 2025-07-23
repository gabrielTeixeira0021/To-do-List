package com.list.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean favorite;

    public Task(String title, String description, boolean favorite) {
        this.title = title;
        this.description = description;
        this.favorite = favorite;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return favorite == task.favorite && Objects.equals(title, task.title) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, favorite);
    }

    @Override
    public String toString() {
        return "Task {id='" + id + '\'' +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", favorite=" + favorite + '\'' +
                '}';
    }
}