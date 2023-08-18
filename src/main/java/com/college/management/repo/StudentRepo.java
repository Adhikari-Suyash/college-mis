package com.college.management.repo;

import com.college.management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepo extends JpaRepository<Student, Long> {
    @Query(
            nativeQuery = true,
            value = "select * from students where roll_no = ?1"
    )Student getByRollNo(Integer roll);
}
