package com.wgalvez.SpringJPA.repository;

import com.wgalvez.SpringJPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByEmail(String email);
    List<Student> findStudentsByRankEquals(String rank);
    @Query("SELECT s FROM Student s WHERE s.firstName like %?1")
    List<Student> findStudentsByNameLike(String l);

    @Query(value = "SELECT * FROM student WHERE first_name like ?1%", nativeQuery = true)
    List<Student> findStudentsByNameLikeNative(String l);

    //Otra forma de pasar parametros a las queries
    @Query(value = "SELECT * FROM student WHERE first_name = :firstName AND age >= :age", nativeQuery = true)
    List<Student> findStudentsByNameLikeNativeTwo(@Param("firstName") String name, @Param("age") Integer age);

    @Transactional
    @Modifying
    @Query("DELETE FROM Student s WHERE s.firstName = ?1")
    int deleteStudent(Long id);

    @Query(value = "SELECT first_name, last_name, card_number FROM student_id_card as s INNER JOIN student as c ON s.card_id=c.student_id", nativeQuery = true)
    List<Student> findStudentsWhitCard();
}
