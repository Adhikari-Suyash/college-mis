package com.college.management.config;

import com.college.management.entity.Role;
import com.college.management.entity.Student;
import com.college.management.entity.User;
import com.college.management.repo.RoleRepo;
import com.college.management.repo.StudentRepo;
import com.college.management.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class InitDbConfig {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final StudentRepo studentRepo;

    @PostConstruct
    public void addData(){
        //Initializing Roles if Roles Table Empty
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

        //Initializing Test-Student if Students table empty
        if (studentRepo.findAll().size()==0){
            Student student = new Student();
            student.setFirstName("Test");
            student.setLastName("Student");
            student.setAddress("Kathmandu");
            student.setRollNo(0);
            student.setBatch(2001);
            User user = new User();
            String username = student.getBatch().toString()+student.getRollNo().toString();
            user.setUserName(username);
            user.setPassword("test");
            user.setRoles(Arrays.asList(roleRepo.getByRole("student")));
            student.setUser(user);
            userRepo.save(user);
            studentRepo.save(student);

        }
    }
}
