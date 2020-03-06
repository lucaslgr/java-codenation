package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    @NotNull
    @Size(max = 100)
    private String fullName;

    @Column
    @NotNull
    @Email
    @Size(max = 100)
    private String email;

    @Column(name = "nickname")
    @NotNull
    @Size(max = 50)
    private String nickName;

    @Column
    @NotNull
    @Size(max = 255)
    private String password;

    @Column(name = "created_at")
    @NotNull
    @CreatedDate
    private LocalDateTime createdAt;

    //Mapeando relações 1 -> *
    @OneToMany(mappedBy = "id.user")
    private List<Candidate> candidateList;

    @OneToMany(mappedBy = "id.user")
    private List<Submission> submissions;

    //Constructor default
    public User() {}
}