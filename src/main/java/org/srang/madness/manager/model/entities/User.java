package org.srang.madness.manager.model.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * Created by srang on 11/5/2016.
 */
@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id", unique = true, nullable = false)
    Integer userId;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "email", unique = true, nullable = false)
    String email;
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    Status status;
    @Column(name = "password", nullable = false)
    String password;
    @Column(name = "remember_token")
    String rememberToken;

    @Builder
    public User(Integer userId, String firstName, String lastName, String email, Status status, String password, String rememberToken) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
        this.password = password;
        this.rememberToken = rememberToken;
    }
}
