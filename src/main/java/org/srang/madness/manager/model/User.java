package org.srang.madness.manager.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

/**
 * Created by srang on 11/5/2016.
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    Integer userId;
    String name;
    String email;
    Integer statusId;
    String password;
    String rememberToken;
}
