package com.example.webtaskmanager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "task")
@Getter
@Setter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskid;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private String status;

    @Column(name = "describe")
    private String describe;
}
