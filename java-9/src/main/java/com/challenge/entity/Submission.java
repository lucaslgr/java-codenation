package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity(name = "submission")
@EntityListeners(AuditingEntityListener.class)
public class Submission {

//    @Column(name = "user_id")
//    @Embedded
//    private Long userId;
//
//    @Column(name = "challenge_id")
//    private Long challengeId;

    @EmbeddedId
    private SubmissionId keySub;

    @Column
    @NotNull
    private Float score;

    @Column(name = "created_at")
    @CreatedDate
    @NotNull
    private LocalDateTime createdAt;

    //Constructor default
    public Submission() {}
}
