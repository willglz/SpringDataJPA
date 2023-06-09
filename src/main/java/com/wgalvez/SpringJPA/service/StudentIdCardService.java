package com.wgalvez.SpringJPA.service;

import com.wgalvez.SpringJPA.model.StudentIdCard;
import com.wgalvez.SpringJPA.repository.dao.StudentIdCardDAO;
import com.wgalvez.SpringJPA.request.StudentIdCardRegistrationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentIdCardService {
    private final StudentIdCardDAO studentIdCardDAO;

    public StudentIdCardService(StudentIdCardDAO studentIdCardDAO) {
        this.studentIdCardDAO = studentIdCardDAO;
    }

    public List<StudentIdCard> getAllCards(){
        return studentIdCardDAO.showAllStudentsCards();
    }

    public void addCard(StudentIdCardRegistrationRequest request){
        studentIdCardDAO.insertStudentCard(new StudentIdCard(request));
    }

    public void removeStudenIdCard(Long id){
        studentIdCardDAO.deleteStudentIdCard(id);
    }
}
