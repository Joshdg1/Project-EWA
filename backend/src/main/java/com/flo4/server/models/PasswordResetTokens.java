package com.flo4.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "password_reset_tokens")
public class PasswordResetTokens {
    /**
     * Entity class for making a connection between password reset tokens and users
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String token;

    @JsonIgnore
    @ManyToOne
    private User user;
}
