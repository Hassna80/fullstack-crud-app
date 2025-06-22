package com.example.taskborad.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Getter @Setter
    protected String title;

    @Getter @Setter
    protected String description;

    @Getter @Setter
    protected Date dueDate;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    protected Priority priority;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    protected Status status;


    public enum Status {
        PENDING, IN_PROGRESS, COMPLETED
    }

    public enum Priority {
        LOW, MEDIUM, HIGH
    }
}
