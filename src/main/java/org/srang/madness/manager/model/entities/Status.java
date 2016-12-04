package org.srang.madness.manager.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by srang on 11/5/2016.
 */
@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "statuses")
public class Status implements Serializable {
    /* TODO define enum */

    @Id
    @GeneratedValue
    @Column(name = "status_id", unique = true, nullable = false)
    Integer statusId;
    @Column(name = "status", nullable = false)
    String status;
}
