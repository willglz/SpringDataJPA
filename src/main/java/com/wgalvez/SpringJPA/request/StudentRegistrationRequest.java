package com.wgalvez.SpringJPA.request;

import com.wgalvez.SpringJPA.model.StudentIdCard;

public record StudentRegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String rank,
        Integer age,
        StudentIdCardRecord studentIdCardRecord
) {
}
