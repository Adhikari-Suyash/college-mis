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
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="address")
    private String address;

    @Column(name = "phone")
    private Long phone;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "uid")
    private User user;
}
