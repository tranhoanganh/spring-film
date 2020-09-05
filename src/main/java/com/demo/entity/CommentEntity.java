package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
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
    private Timestamp createAt;

    @Column(name = "update_at")
    private Timestamp updateAt;

    @OneToOne()
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    private UserEntity user;

    @ManyToOne()
    @JoinColumn(name = "filmid", insertable = false, updatable = false)
    private FilmEntity film;

}
