package com.example.taskborad.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
public abstract class Task implements Serializable {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;

    @Getter @Setter
    protected String title;

    @Getter @Setter
    protected String description;

    @Getter @Setter
    protected Date dueDate;

    @Getter @Setter
    protected int priority;

    @Getter @Setter
    protected String status;
}
