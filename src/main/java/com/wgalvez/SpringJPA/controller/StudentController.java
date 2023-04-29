package com.wgalvez.SpringJPA.controller;

import com.wgalvez.SpringJPA.model.Student;
import com.wgalvez.SpringJPA.request.StudentRegistrationRequest;
import com.wgalvez.SpringJPA.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //@GetMapping
    //public List<Student> getStudents(){return studentService.getAllStudents();}

    @GetMapping
    public List<Student> getStudentsWithCard(){
        return studentService.getAllStudentsWithCard();
    }

    @PostMapping
    public void saveStudent(@RequestBody StudentRegistrationRequest[] request){
        studentService.addStudent(request);
    }

    @DeleteMapping("{studentId}")
    public void removeStudent(@PathVariable("studentId") Long id){
        studentService.removeStudent(id);
    }

    @GetMapping("count")
    public Long totalStudent(){
        return studentService.countStudent();
    }

    @PostMapping ("email")
    public Student getStudentByEmail(@RequestParam("email") String email){
        return studentService.findStudentByEmail(email);
    }

    @PostMapping("rank")
    public List<Student> getStudentsByRank(@RequestParam("rank") String rank){
        return studentService.showStudentsByRank(rank);
    }

    @PostMapping("like")
    public List<Student> getStudentsByNameLike(@RequestParam("like") String like){
        return studentService.showStudentsByNameLike(like);
    }

    @GetMapping("{studentId}")
    public Student getStudentById(@PathVariable("studentId") Long id){
        return studentService.findStudentById(id);
    }
}
