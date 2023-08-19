package com.college.management.config;

import com.college.management.entity.Faculty;
import com.college.management.entity.Role;
import com.college.management.entity.Student;
import com.college.management.entity.User;
import com.college.management.repo.FacultyRepo;
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
    private final FacultyRepo facultyRepo;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final StudentRepo studentRepo;

    @PostConstruct
    public void addData(){
        //Initializing Faculties if Faculty Table Empty
        if (facultyRepo.findAll().size()==0){
            //Creating and saving BSC faculty
            Faculty bsc = new Faculty();
            bsc.setName("BSC");
            bsc.setYears(4);
            bsc.setSemesters(8);
            facultyRepo.save(bsc);

            //Creating and saving BBA faculty
            Faculty bba = new Faculty();
            bba.setName("BBA");
            bba.setYears(4);
            bba.setSemesters(8);
            facultyRepo.save(bba);

            //Creating and saving BIM faculty
            Faculty bim = new Faculty();
            bim.setName("BIM");
            bim.setYears(4);
            bim.setSemesters(8);
            facultyRepo.save(bim);
        }


        //Initializing Roles if Roles Table Empty
        if (roleRepo.findAll().size()==0){
            //Creating System Admin Role
            Role adminRole = new Role();
            adminRole.setName("SYSADMIN");
            roleRepo.save(adminRole);

            //Creating Student Role
            Role studentRole = new Role();
            studentRole.setName("STUDENT");
            roleRepo.save(studentRole);

            //Creating Teacher Role
            Role teacherRole = new Role();
            teacherRole.setName("TEACHER");
            roleRepo.save(teacherRole);
        }

        //Initializing Test-Student if Students table empty
        if (studentRepo.findAll().size()==0){
            Student student = new Student();
            student.setFirstName("Test");
            student.setLastName("Student");
            student.setAddress("Kathmandu");
            student.setPhone(9800000000L);
            student.setRollNo(100);
            student.setBatch(2019);
            student.setFaculty(facultyRepo.getByName("BSC"));
            User user = new User();
            Integer b = student.getBatch()-2000;
            String batch = Integer.toString(b);
            String username = student.getFaculty().getName()+batch+student.getRollNo().toString();
            user.setUserName(username);
            user.setPassword("test");
            user.setRoles(Arrays.asList(roleRepo.getByRole("STUDENT")));
            student.setUser(user);
            userRepo.save(user);
            studentRepo.save(student);

        }
    }
}
