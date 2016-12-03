package org.srang.madness.manager.model.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * Created by srang on 11/5/2016.
 */
@Data
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    Integer userId;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "email", nullable = false)
    String email;
    @Column(name = "status_id")
    Integer statusId;
    @Column(name = "password")
    String password;
    @Column(name = "remember_token")
    String rememberToken;
}
