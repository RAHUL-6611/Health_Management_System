package com.application.healthmanegmentsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "totalcareService")
public class TotalcareService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "totalCare_id")
    private Long id;
    @NotEmpty(message = "Name can't be Empty")
    private String name;
    @NotEmpty(message = "Phonenumber can't be Empty")
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;
    private int familySize;
    private Boolean status;
}
