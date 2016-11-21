package org.srang.madness.manager.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.transaction.SavepointManager;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by srang on 11/5/2016.
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Game implements Serializable {
    @Id
    Integer gameId;
    Integer teamAId;
    Integer teamBId;
    Integer scoreA;
    Integer scoreB;
    Boolean isMaster;
    Integer winner;
    Integer roundId;
    Integer childGameA;
    Integer childGameB;
}
