package org.srang.bracketpicker.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.transaction.SavepointManager;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import java.io.Serializable;

/**
 * Created by srang on 11/5/2016.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Game implements Serializable {
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
