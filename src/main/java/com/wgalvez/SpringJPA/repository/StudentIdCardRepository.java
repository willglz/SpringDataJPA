package com.wgalvez.SpringJPA.repository;

import com.wgalvez.SpringJPA.model.StudentIdCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentIdCardRepository extends CrudRepository<StudentIdCard, Long> {

    @Query("SELECT c FROM StudentIdCard c INNER JOIN Student s ON s.id=c.id")
    List<StudentIdCard> findAllStudentsCard();
}
