package com.application.healthmanegmentsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medicineService")
public class MedicineService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private Long id;
    @NotEmpty(message = "Name can't be Empty")
    private String name;
    @NotEmpty(message = "PhoneNumber can't be Empty")
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;
    @NotEmpty(message = "Email can't be Empty")
    private String email;
    @NotEmpty(message = "Precription can't be Empty")
    private String precription;
    private boolean status;
}
