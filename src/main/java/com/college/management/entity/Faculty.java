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
@Table(name = "faculties")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fid;

    @Column(name = "faculty", nullable = false, unique = true)
    private String name;

    @Column(name = "years", nullable = false)
    private Integer years;

    @Column(name = "semesters", nullable = false)
    private Integer semesters;
}
