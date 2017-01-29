package com.github.srang.madness.model.entities;

import lombok.Builder;
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
@Table(name = "blogs")
public class Blog implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "blog_id", unique = true, nullable = false)
    Integer blogId;
    @Column(name = "content")
    String content;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    Blog parent;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @Builder
    public Blog(String content, Blog parent, User user) {
        this.content = content;
        this.parent = parent;
        this.user = user;
    }

}
