package com.college.management.config;

import com.college.management.entity.Role;
import com.college.management.entity.Student;
import com.college.management.repo.RoleRepo;
import com.college.management.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
public class InitDbConfig {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @PostConstruct
    public void addRoleData(){
        //Adding Roles if Roles Table Empty
        if (roleRepo.findAll().size()==0){
            //Creating System Admin Role
            Role adminRole = new Role();
            adminRole.setName("SYSADMIN");
            Role savedAdmin =  roleRepo.save(adminRole);

            //Creating Student Role
            Role studentRole = new Role();
            studentRole.setName("STUDENT");
            Role savedStudent =  roleRepo.save(studentRole);

            //Creating Teacher Role
            Role teacherRole = new Role();
            teacherRole.setName("TEACHER");
            Role savedTeacher =  roleRepo.save(teacherRole);
        }


    }
}
