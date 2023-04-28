package com.wgalvez.SpringJPA.repository.das;

import com.wgalvez.SpringJPA.model.StudentIdCard;
import com.wgalvez.SpringJPA.repository.StudentIdCardRepository;
import com.wgalvez.SpringJPA.repository.dao.StudentIdCardDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentIdCardDAS implements StudentIdCardDAO {
    private final StudentIdCardRepository studentIdCardRepository;

    public StudentIdCardDAS(StudentIdCardRepository studentIdCardRepository) {
        this.studentIdCardRepository = studentIdCardRepository;
    }

    @Override
    public List<StudentIdCard> showAllStudentsCards() {
        return studentIdCardRepository.findAllStudentsCard() ;
    }

    @Override
    public void insertStudentCard(StudentIdCard studentIdCard) {
        studentIdCardRepository.save(studentIdCard);
    }
}
