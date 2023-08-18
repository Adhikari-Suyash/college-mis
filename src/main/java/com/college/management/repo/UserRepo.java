package com.college.management.repo;

import com.college.management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query(
            nativeQuery = true,
            value = "select * from users where user_name=?1"
    )
    User findUserByUserName(String username);
}
