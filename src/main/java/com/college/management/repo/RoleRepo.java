package com.college.management.repo;

import com.college.management.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepo extends JpaRepository<Role, Long> {
    @Query(
            nativeQuery = true,
            value = "select * from roles where name = ?1"
    )
    Role getByRole(String role);
}
