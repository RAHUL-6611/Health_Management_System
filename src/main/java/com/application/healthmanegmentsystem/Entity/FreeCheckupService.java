package com.application.healthmanegmentsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "freeCheckupService")
public class FreeCheckupService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "freeCheckup_id")
    private Long id;
    @NotEmpty(message = "Name can't be Empty")
    private String name;
    @NotEmpty(message = "Phonenumber can't be Empty")
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;
    @Email(message = "Invalid email")
    @NotEmpty(message = "Email can't be Empty")
    private String email;
    @NotEmpty(message = "Issue can't be Empty")
    private String issue;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private boolean status;
}
