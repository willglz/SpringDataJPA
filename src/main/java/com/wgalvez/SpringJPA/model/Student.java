package com.wgalvez.SpringJPA.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wgalvez.SpringJPA.request.StudentRegistrationRequest;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Student")
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(name = "student_email_unique", columnNames = "email")
        }
)
@Getter @Setter @NoArgsConstructor @ToString
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "student_id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;
    @Column(
            name = "rank",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String rank;

    @Column(
            name = "age",
            nullable = false
    )
    private Integer age;

    @OneToOne(
            mappedBy = "student",
            orphanRemoval = true
    )

    private StudentIdCard studentIdCard;

    public Student(String firstName, String lastName, String email, String rank, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.rank = rank;
        this.age = age;
    }

    public Student(StudentRegistrationRequest studentRegistrationRequest){
        this.firstName = studentRegistrationRequest.firstName();
        this.lastName = studentRegistrationRequest.lastName();
        this.email = studentRegistrationRequest.email();
        this.rank = studentRegistrationRequest.rank();
        this.age = studentRegistrationRequest.age();
    }
}