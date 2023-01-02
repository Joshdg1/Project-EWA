package com.flo4.server.models;

import com.flo4.server.models.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "password_reset_tokens")
public class PasswordResetTokenEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String token;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
