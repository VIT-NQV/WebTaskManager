package com.example.webtaskmanager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    @Column(name = "fullname")
    @NotBlank(message = "Fullname not null")
    private String fullname;

    @Column(name = "username")
    @NotBlank(message = "Username not null")
    private String username;

    @Column(name = "password")
    @NotBlank(message = "Password not null")
    private String password;

}
