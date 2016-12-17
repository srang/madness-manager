package org.srang.madness.manager.model.entities;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * Created by srang on 12/11/16.
 */
@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user_roles")
public class UserRole {
    @Id
    @GeneratedValue
    @Column(name = "user_role_id", nullable = false, unique = true)
    Integer userRoleId;
    @Column(name = "username", nullable = false)
    String username;
    @Column(name = "role", nullable = false)
    String role;

    @Builder
    public UserRole(String username, String role) {
        this.username = username;
        this.role = role;
    }
}
