package com.college.management.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "subject_code", nullable = false)
    private String subjectCode;

    @Column(name = "subject", nullable = false)
    private String name;

    @Column(name = "th_full_marks", nullable = false)
    private Integer theoryFullMarks;

    @Column(name = "pr_full_marks", nullable = false)
    private Integer practicalFullMarks;

    @Column(name = "in_full_marks", nullable = false)
    private Integer internalFullMarks;

    @Column(name = "credit", nullable = false)
    private Integer credit;

    @ManyToOne
    private Semester semester;
}
