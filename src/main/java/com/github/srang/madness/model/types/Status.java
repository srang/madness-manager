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
@Table(name = "statuses")
public class Status implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "status_id", unique = true, nullable = false)
    Integer statusId;
    @Column(name = "status", nullable = false)
    String status;

    private Status(Integer id, String desc) {
        this.statusId = id;
        this.status = desc;
    }

    public enum StatusType {

        UNVERIFIED(1, "Unverified"),
        ACTIVE(2, "Active"),
        DISABLED(3, "Disabled"),
        EXPIRED(4, "Expired");

        private int id;

        private String value;

        private StatusType(int id, String value) {
            this.id = id;
            this.value = value;
        }

        public int getId() {
            return id;
        }

        public Integer getIntegerId() {
            return Integer.valueOf(id);
        }

        public String getValue() {
            return value;
        }

        public Status status() {
            return new Status(this.id, this.value);
        }

        public boolean isEqual(Status status) {
            return status.getStatusId().equals(this.getIntegerId());
        }
    }
}


