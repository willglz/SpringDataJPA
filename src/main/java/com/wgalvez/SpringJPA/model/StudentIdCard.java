package com.wgalvez.SpringJPA.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wgalvez.SpringJPA.request.StudentIdCardRegistrationRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "StudentIdCard")
@Table(
        name = "student_id_card",
        uniqueConstraints = {
                @UniqueConstraint(name = "student_id_card_number_unique", columnNames = "card_number")
        }
)
@Getter @Setter @NoArgsConstructor @ToString
public class StudentIdCard {

    @Id
    @SequenceGenerator(
            name = "student_id_card_sequence",
            sequenceName = "student_id_card_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_card_sequence"
    )
    @Column(
            name = "card_id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "card_number",
            nullable = false,
            length = 15
    )
    private String cardNumber;

    @OneToOne
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "student_id",
            foreignKey = @ForeignKey(
                    name = "student_id_card_student_id_fk"
            )
    )

    private Student student;

    public StudentIdCard(StudentIdCardRegistrationRequest studentIdCardRegistrationRequest) {
        this.cardNumber = studentIdCardRegistrationRequest.cardNumber();
        this.student = new Student(studentIdCardRegistrationRequest.student());
    }
}
