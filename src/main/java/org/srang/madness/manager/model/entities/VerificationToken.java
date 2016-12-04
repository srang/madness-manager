package org.srang.madness.manager.model.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by srang on 11/5/2016.
 */
@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "verification_tokens")
public class VerificationToken implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "verfication_id", unique = true, nullable = false)
    Integer verificationId;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    User user;
    @Column(name = "token", nullable = false)
    String token;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "expires", nullable = false)
    Date expires;

    @Builder
    public VerificationToken(User user, String token, Date expires) {
        this.user = user;
        this.token = token;
        this.expires = expires;
    }
}
