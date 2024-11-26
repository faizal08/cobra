package com.practice.cobra.controller;

import com.practice.cobra.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    private Map<Long, Student> students = new HashMap<>();

    @GetMapping
    public List<Student> getAll(){
         return new ArrayList<>(students.values());
    }

    @PostMapping
    public boolean createStudent(@RequestBody Student student){
            students.put(student.getId(),student);
            return true;
    }

    @GetMapping("/id/{studentId}")
    public Student getStudentById(@PathVariable Long studentId){
          return students.get(studentId);
    }

    @DeleteMapping("/id/{studentId}")
    public Student deleteStudentById(@PathVariable Long studentId){
        return students.remove(studentId);
    }

    @PutMapping("/id/{studentId}")
    public boolean updateStudentById(@PathVariable Long studentId,@RequestBody Student student){
        students.put(studentId,student);
        return true;
    }
}
