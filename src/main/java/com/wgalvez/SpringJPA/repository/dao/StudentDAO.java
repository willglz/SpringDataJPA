package com.wgalvez.SpringJPA.repository.dao;

import com.wgalvez.SpringJPA.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDAO {
    List<Student> showAllStudent();
    void insertStudent(List<Student> students);
    void deleteStudent(Long id);
    Long studentTotal();
    Optional<Student> findStudentByEmail(String email);
    List<Student> findStudentsByRank(String rank);
    List<Student> findStudentsByNameLike(String l);

    Optional<Student> findStudentById(Long id);
}
