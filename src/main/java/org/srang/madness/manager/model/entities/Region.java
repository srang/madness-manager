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
@Table(name = "regions")
public class Region implements Serializable {
    /* TODO define enum */

    @Id
    @GeneratedValue
    @Column(name = "region_id", unique = true, nullable = false)
    Integer regionId;
    @Column(name = "region", nullable = false)
    String name;
}
