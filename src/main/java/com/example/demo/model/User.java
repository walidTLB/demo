package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "validation_period")
    private Integer validationPeriod; // in days

    @Column(name = "interim")
    private boolean interim;

    private boolean isActive;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;
    public String getEmail() {
        return email;
    }
    @Enumerated(EnumType.STRING)
    private Role role;

    @Transient
    private String token;

    @Column( name = "create_time", nullable = false )
    private LocalDateTime createTime;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

}


