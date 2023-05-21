package com.application.healthmanegmentsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserInfo {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "* FirstName Can't be blank")
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @NotEmpty
    @Email
    @Column(nullable = false, unique = true)
    private String username;
    @NotEmpty
    private String password;
    private String mobileNo;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private Boolean enabled;
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "users_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<Role> roles = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Role roles;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="user_appointments")
    private Set<Appointment> appointmentList;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="ambulance_service")
    private Set<AmbulanceService> ambulanceServiceList;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="bedFacility_service")
    private Set<BedFacilityService> bedFacilityServiceList;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="freeCheckup_service")
    private Set<FreeCheckupService> freeCheckupServiceList;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="medicine_service")
    private Set<MedicineService> medicineServicesList;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="totalcare_service")
    private Set<TotalcareService> totalcareServicesList;

    @Transient
    private String role;

}
