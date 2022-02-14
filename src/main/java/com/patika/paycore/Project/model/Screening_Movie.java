package com.patika.paycore.Project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "screening_movie")
public class Screening_Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Movie can not be null")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    @NotNull(message = "Theatre can not be null")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "theatre_id", referencedColumnName = "id")
    private Theatre theatre;

    @NotNull(message = "Screening date can not be null")
    @Column(name = "date_of_screening")
    private Date date_of_screening;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "screening_movie", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}
