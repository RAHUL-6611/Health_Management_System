package com.application.healthmanegmentsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long id;
    @NotBlank(message = "Name can't be blank")
    private String name;
    @NotEmpty(message = "Mobile can't be Empty")
    @Pattern(regexp="(^$|[0-9]{10})")
    private String mobileNo;
    @Email(message = "Invalid Email formate")
    @NotEmpty(message = "Email can't be Empty")
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;
    private Boolean status;
}
