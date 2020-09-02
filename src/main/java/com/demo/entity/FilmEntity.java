package com.demo.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "film")
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "description")
    private String description;

    @Column(name = "categoryid")
    private Integer categoryid;

    @Column(name = "directorid")
    private Integer directorid;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "view")
    private Integer view;

    @Column(name = "url")
    private String url;

    @Column(name = "create_at")
    private java.sql.Timestamp createAt;

    @Column(name = "update_at")
    private java.sql.Timestamp updateAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "film_cast",
            joinColumns = @JoinColumn(name = "filmid"),
            inverseJoinColumns = @JoinColumn(name = "castid")
    )
    private List<CastEntity> casts;

    @ManyToOne() //EAGER
    @JoinColumn(name = "categoryid", insertable = false, updatable = false)
    private CategoryEntity category;

    @ManyToOne()
    @JoinColumn(name = "directorid", insertable = false, updatable = false)
    private DirectorEntity director;

    @JsonIgnore
    @OneToMany(mappedBy = "film")
    private List<CommentEntity> comments;
}
