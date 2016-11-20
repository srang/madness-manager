package org.srang.bracketpicker.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * Created by srang on 11/5/2016.
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Team {
    Integer teamId;
    String name;
    Integer rank;
    Integer regionId;
    String mascot;
    String iconPath;
    String primaryColor;
    String accentColor;
}
