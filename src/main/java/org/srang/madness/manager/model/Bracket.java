package org.srang.madness.manager.model;


import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by srang on 11/5/2016.
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Bracket implements Serializable {
    @Id
    Integer bracketId;
    Integer userId;
    Integer rootGame;
    String name;
    Boolean isMaster;
}
