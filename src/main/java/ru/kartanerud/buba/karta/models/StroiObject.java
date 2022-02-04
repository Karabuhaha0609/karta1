package ru.kartanerud.buba.karta.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.kartanerud.buba.karta.models.enamy.VidCar;

import javax.persistence.*;
import java.security.Principal;
import java.text.NumberFormat;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "stroi_object")
public class StroiObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stroi_object_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_stroy_id")
    private ClientStroy clientStroy;
    private String kontaktNachUch;
    private String kontaktProrab;
    private String addressStroiObject;
    private String coordinatyStroiObject;
    @Enumerated(EnumType.STRING)
    private VidCar vidCar;
    private boolean propusk;
    private boolean russianVoditel;
    private boolean passportVoditel;
    private LocalTime vremyaPriemkiStart;
    private LocalTime vremyaPriemkiFinish;
    private int plechoReis;
    private double priceReis;
    private String kommentarii;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reis> reises;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "orders_stroi_object",
            joinColumns = @JoinColumn(name = "stroi_object_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public StroiObject(Principal principal) {
    }
}
