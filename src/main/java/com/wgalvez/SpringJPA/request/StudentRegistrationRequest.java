package com.wgalvez.SpringJPA.request;

public record StudentRegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String rank,
        Integer age
) {
}
