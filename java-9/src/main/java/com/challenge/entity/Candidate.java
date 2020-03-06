package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity(name = "candidate")
@EntityListeners(AuditingEntityListener.class)
public class Candidate {

//    @ManyToOne
//    private User user;
//
//    @ManyToOne
//    private Acceleration acceleration;
//
//    @ManyToOne
//    private Company company;
    @EmbeddedId
    private CandidateId keyCandidate;

    @Column
    @NotNull
    private long status;

    @Column(name = "created_at")
    @NotNull
    @CreatedDate
    private LocalDateTime createdAt;
}
