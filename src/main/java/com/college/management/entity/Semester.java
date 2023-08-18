package com.college.management.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "semesters")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "semester", nullable = false, unique = true)
    private String name;

    @Column(name = "semester_fee", nullable = false)
    private Double fee;

    @ManyToOne
    private Faculty faculty;

    @OneToMany
    private List<Subject> subjects;
}
