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
        StudentIdCard studentIdCard = new StudentIdCard();
        studentIdCard.setCardNumber(request.cardNumber());
        studentIdCard.setStudent(request.student());
        studentIdCardDAO.insertStudentCard(studentIdCard);
    }
}
