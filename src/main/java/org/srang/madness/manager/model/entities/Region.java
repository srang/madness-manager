package org.srang.madness.manager.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by srang on 11/5/2016.
 */
@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "regions")
public class Region implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "region_id", unique = true, nullable = false)
    Integer regionId;
    @Column(name = "region", nullable = false)
    String name;

    private Region(Integer id, String name) {
        this.regionId = id;
        this.name = name;
    }
    public enum RegionType {

        EAST(1, "East"),
        WEST(2, "West"),
        SOUTH(3, "South"),
        MIDWEST(4, "Midwest"),
        UNSPECIFIED(5, "");
        private int id;

        private String value;

        private RegionType(int id, String value) {
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

        public Region region() {
            return new Region(this.getIntegerId(), this.value);
        }

        public boolean isEqual(Region Region) {
            return region().getRegionId().equals(this.getIntegerId());
        }

        public static RegionType valueOf(Integer id) {
            return Arrays.stream(RegionType.values()).filter(r -> r.getIntegerId().equals(id)).findFirst().get();
        }
    }
}
