package com.github.srang.madness.model.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.github.srang.madness.model.types.LinkType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by srang on 11/5/2016.
 */
@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "bloglinks")
public class BlogLink implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "link_id", unique = true, nullable = false)
    Integer linkId;
    @JoinColumn(name = "blog_id", nullable = false)
    Blog blog;
    @JoinColumn(name = "linktype_id", nullable = false)
    LinkType type;

    @Builder
    public BlogLink(Blog blog, LinkType type) {
        this.blog = blog;
        this.type = type;
    }
}
