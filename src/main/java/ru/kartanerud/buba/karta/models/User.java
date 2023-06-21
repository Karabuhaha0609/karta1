package ru.kartanerud.buba.karta.models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "full_name")
        private String fullName;

    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;


    @Column(name = "photo")
    private String photo;
    @Column(name = "password", length = 1000)
    @Size(min = 4)
    private String password;
    @Transient
    private String matchingPassword; // временное поле для подтверждения пароля
    @Column(name = "email", unique = true)
    @NotNull
    @Email
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = true)
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_instruction",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "instruction_id"))
    private Set<Instruction> instructions = new HashSet<>();

    @PrePersist
    @PreUpdate
    public void preUpdate() {
        this.fullName = getFirstName() + " " + getLastName();
    }

    public Long getCompanyId() {
        if (company == null) {
            return null;
        }
        return company.getId();
    }

    public Company getCompany() {
        return company;
    }

}
