package com.wgalvez.SpringJPA.repository.dao;

import com.wgalvez.SpringJPA.model.StudentIdCard;

import java.util.List;

public interface StudentIdCardDAO {
    List<StudentIdCard> showAllStudentsCards();
    void insertStudentCard(StudentIdCard studentIdCard);
    void deleteStudentIdCard(Long id);
}
