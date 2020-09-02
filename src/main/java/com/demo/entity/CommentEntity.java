package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "userid")
    private Integer userid;

    @Column(name = "filmid")
    private Integer filmid;

    @Column(name = "content")
    private String content;

    @Column(name = "create_at")
    private java.sql.Timestamp createAt;

    @Column(name = "update_at")
    private java.sql.Timestamp updateAt;

    @ManyToOne() //EAGER
    @JoinColumn(name = "filmid", insertable = false, updatable = false)
    private FilmEntity film;

}
