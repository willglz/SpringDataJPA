package com.wgalvez.SpringJPA.repository.das;

import com.wgalvez.SpringJPA.model.Student;
import com.wgalvez.SpringJPA.repository.StudentRepository;
import com.wgalvez.SpringJPA.repository.dao.StudentDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentDAS implements StudentDAO {
    private final StudentRepository studentRepository;

    public StudentDAS(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> showAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void insertStudent(List<Student> student) {
        studentRepository.saveAll(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Long studentTotal() {
        return studentRepository.count();
    }

    @Override
    public Optional<Student> findStudentByEmail(String email) {
        return studentRepository.findStudentByEmail(email);
    }

    @Override
    public List<Student> findStudentsByRank(String rank) {
        return studentRepository.findStudentsByRankEquals(rank);
    }

    @Override
    public List<Student> findStudentsByNameLike(String l) {
        return studentRepository.findStudentsByNameLikeNative(l);
    }

    @Override
    public Optional<Student> findStudentById(Long id) {
        return studentRepository.findById(id);
    }
}
