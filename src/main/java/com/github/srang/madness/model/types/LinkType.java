package com.github.srang.madness.model.types;

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
@Table(name = "linktypes")
public class LinkType implements Serializable {
    /* TODO define enum */

    @Id
    @GeneratedValue
    @Column(name = "linktype_id", unique = true, nullable = false)
    Integer linkTypeId;
    @Column(name = "type", nullable = false)
    String type;
}
