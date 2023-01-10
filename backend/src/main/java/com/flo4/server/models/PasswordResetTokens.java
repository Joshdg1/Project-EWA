package com.flo4.server.models;

import com.flo4.server.models.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "password_reset_tokens")
public class PasswordResetTokens implements Serializable {
    /**
     * Entity class for making a connection between password reset tokens and users
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String token;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user_id;
}
