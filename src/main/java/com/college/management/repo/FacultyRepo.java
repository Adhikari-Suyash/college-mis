package com.college.management.repo;

import com.college.management.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FacultyRepo extends JpaRepository<Faculty, Long> {
    @Query(
            nativeQuery = true,
            value = "select * from faculties where faculty = ?1"
    )
    Faculty getByName(String name);
}
