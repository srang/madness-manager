package org.srang.madness.manager.model.entities;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by srang on 12/11/16.
 */
@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user_roles")
public class UserRole implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "user_role_id", nullable = false, unique = true)
    Integer userRoleId;
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    User user;
    @Column(name = "role", nullable = false)
    String role;

    @Builder
    public UserRole(User user, String role) {
        this.user = user;
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "role='" + role + '\'' +
                '}';
    }
}
