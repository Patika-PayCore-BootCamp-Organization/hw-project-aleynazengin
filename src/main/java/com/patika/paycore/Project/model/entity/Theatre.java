package com.patika.paycore.Project.model.entity;

import com.patika.paycore.Project.model.entity.Screening_Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "theatre")
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Name can not be null")
    private String name;

    @NotNull(message = "City can not be null")
    private String city;

    @NotNull(message = "District can not be null")
    private String district;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Screening_Movie> screening_movies;
}
