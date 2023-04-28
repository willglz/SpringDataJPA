package com.wgalvez.SpringJPA.controller;

import com.wgalvez.SpringJPA.model.StudentIdCard;
import com.wgalvez.SpringJPA.request.StudentIdCardRegistrationRequest;
import com.wgalvez.SpringJPA.service.StudentIdCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cards")
public class StudentIdCardController {
    private final StudentIdCardService studentIdCardService;

    public StudentIdCardController(StudentIdCardService studentIdCardService) {
        this.studentIdCardService = studentIdCardService;
    }

    @GetMapping
    public List<StudentIdCard> getCards(){
        return studentIdCardService.getAllCards();
    }

    @PostMapping
    public void addCard(@RequestBody StudentIdCardRegistrationRequest request){
        studentIdCardService.addCard(request);
    }
}
