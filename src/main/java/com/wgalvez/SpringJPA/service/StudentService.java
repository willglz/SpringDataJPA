package com.wgalvez.SpringJPA.service;

import com.wgalvez.SpringJPA.exception.ResourseNotFoundException;
import com.wgalvez.SpringJPA.model.Student;
import com.wgalvez.SpringJPA.repository.dao.StudentDAO;
import com.wgalvez.SpringJPA.request.StudentRegistrationRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class StudentService {
    private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public List<Student> getAllStudents(){
        return studentDAO.showAllStudent();
    }

    public void addStudent(StudentRegistrationRequest[] request){
        Stream<Student> students = Arrays.stream(request)
                .map(s -> new Student(s.firstName(), s.lastName(), s.email(), s.rank(), s.age()));
        studentDAO.insertStudent(students.toList());
    }

    public void removeStudent(Long id){
        studentDAO.deleteStudent(id);
    }

    public Long countStudent(){
        return studentDAO.studentTotal();
    }

    public Student findStudentByEmail(String email){
        return studentDAO.findStudentByEmail(email)
                .orElseThrow(() -> new ResourseNotFoundException("Student not found"));
    }

    public List<Student> showStudentsByRank(String rank){
        return studentDAO.findStudentsByRank(rank);
    }

    public List<Student> showStudentsByNameLike(String l){
        return studentDAO.findStudentsByNameLike(l);
    }

    public Student findStudentById(Long id){
        return studentDAO.findStudentById(id)
                .orElseThrow(() -> new ResourseNotFoundException("Student not found"));
    }

    public List<Student> getAllStudentsWithCard(){
        return studentDAO.showAllStudentWithCard();
    }
}
