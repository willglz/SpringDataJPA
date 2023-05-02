package com.wgalvez.SpringJPA.request;


public record StudentIdCardRegistrationRequest(
        String cardNumber,
        StudentRegistrationRequest student
) {
}
