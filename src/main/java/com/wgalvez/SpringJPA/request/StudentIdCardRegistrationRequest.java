package com.wgalvez.SpringJPA.request;

import com.wgalvez.SpringJPA.model.Student;

public record StudentIdCardRegistrationRequest(
        String cardNumber,
        Student student
) {
}
