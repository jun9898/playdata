package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "mycomment")
public class CommentEntity {
    @Id
    @GeneratedValue
    private Long commentNo;
    @Column(nullable = false)
    private String writer;
    private String content;
    private int rank;
    @CreationTimestamp
    private Date writeData;

    public CommentEntity(String writer, String content, int rank) {
        this.writer = writer;
        this.content = content;
        this.rank = rank;
    }
}
