package com.example.final_assigment.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Target {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long numberOfAssignment;

    @Column
    private Float time;

    @OneToOne(mappedBy = "target")
    private User user;

}
