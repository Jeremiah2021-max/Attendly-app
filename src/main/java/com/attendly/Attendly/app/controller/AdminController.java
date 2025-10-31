package com.attendly.Attendly.app.controller;



import com.attendly.Attendly.app.model.Course;
import com.attendly.Attendly.app.model.Role;
import com.attendly.Attendly.app.model.Users;
import com.attendly.Attendly.app.repo.CourseRepository;
import com.attendly.Attendly.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/admin")

public  class AdminController {

    @Autowired
    private UserService service;

    @PostMapping("/register-student")
    public Users registerStudent(@RequestBody Users user) {
        user.setRole(Role.STUDENT);
        return service.register(user);
    }

    @PostMapping("/register-lecturer")
    public Users registerLecturer(@RequestBody Users user) {
        user.setRole(Role.LECTURER);
        return service.register(user);
    }


    @Autowired
private CourseRepository courseRepository;

@PostMapping("/add-course")
public Course addCourse(@RequestBody Course course){
    return courseRepository.save(course);
}

@PutMapping("/edit-course/{id}")
public Course editCourse(@PathVariable Long id, @RequestBody Course updatedCourse){
    return  courseRepository.findById(id).map(course -> {
        course.setCode(updatedCourse.getCode());
        course.setTitle(updatedCourse.getTitle());
        course.setCreditHours(updatedCourse.getCreditHours());
        course.setDepartment(updatedCourse.getDepartment());
        return courseRepository.save(course);
    }).orElseThrow(()-> new RuntimeException("Course not found"));
}

@GetMapping("/courses")
public List<Course> getAllCourse(){
    return courseRepository.findAll();
}

@DeleteMapping("/delete-course/{id}")
public  String deleteCourse(@PathVariable Long id){
    courseRepository.deleteById(id);
    return "Course deleted successfully";
}
}

