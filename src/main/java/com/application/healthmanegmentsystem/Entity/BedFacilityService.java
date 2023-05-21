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
@Table(name = "bedFacilityService")
public class BedFacilityService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bedFacility_id")
    private Long id;
    @NotEmpty(message = "Name can't be Empty")
    private String name;
    @NotEmpty(message = "Phone Number can't be Empty")
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;
    @NotEmpty(message = "Bed can't be Empty")
    private String bed;
    private Boolean status;
}
