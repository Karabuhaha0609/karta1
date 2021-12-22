package ru.kartanerud.buba.karta.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kartanerud.buba.karta.models.enamy.Role;
import ru.kartanerud.buba.karta.models.enamy.Status;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    @Column(name = "password", length = 1000)
    private String password;
    @Column(name = "email", unique = true)
    private String email;
    private boolean active;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "roles",
            joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(value = EnumType.STRING)
    private Set<Role> roles = new HashSet<>();
    @OneToOne(cascade = CascadeType.REMOVE)
    private Bucket bucket;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    private String phoneNumber;

  /*   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   @JoinColumn(name = "image_id")
    private Image avatar;*/
/*    private LocalDateTime dateOfCreate;

    @PrePersist
    private void init(){
        dateOfCreate = LocalDateTime.now();
    }*/

}
