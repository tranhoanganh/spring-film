package com.demo.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
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

//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    @Transient
    @Column(name = "url")
    private String url;

    @Column(name = "create_at")
    private Timestamp createAt;

    @Column(name = "update_at")
    private Timestamp updateAt;

    @ManyToMany(fetch = FetchType.LAZY)
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

    @OneToMany(mappedBy = "film", fetch = FetchType.LAZY)
    private List<CommentEntity> comments;
}
