package com.patika.paycore.Project.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.patika.paycore.Project.model.entity.Customer;
import com.patika.paycore.Project.model.entity.Screening_Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @NotNull(message = "Screening Movie can not be null")
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "screening_movie_id", referencedColumnName = "id")
    private Screening_Movie screening_movie;

    @NotNull(message = "Price can not be null")
    private int price;
}
