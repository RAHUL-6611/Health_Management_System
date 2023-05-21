package com.application.healthmanegmentsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ambulanceService")
public class AmbulanceService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aumbulance_id")
    private Long id;
    @NotEmpty(message = "*Name can't be Empty")
    private String name;
    @NotEmpty(message = "*PhoneNumber can't be Empty")
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;
    @NotEmpty(message = "*Address can't be Empty")
    private String Address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;
    private Boolean status;
}
