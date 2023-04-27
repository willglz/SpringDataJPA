package com.wgalvez.SpringJPA.repository;

import com.wgalvez.SpringJPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByEmail(String email);
    List<Student> findStudentsByRankEquals(String rank);
    @Query("SELECT s FROM Student s WHERE s.firstName like %?1")
    List<Student> findStudentsByNameLike(String l);

    @Query(value = "SELECT * FROM student WHERE first_name like ?1%", nativeQuery = true)
    List<Student> findStudentsByNameLikeNative(String l);
}
