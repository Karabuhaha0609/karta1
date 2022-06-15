package ru.kartanerud.buba.karta.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.kartanerud.buba.karta.models.enamy.StatusReis;

import javax.persistence.*;
import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "reises")
public class Reis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reis_id")
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataReis;
    private LocalTime timeReis;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
    private LocalDate startOtgruzki;
    private LocalDate finishOtgruzka;
    private LocalDate iskluchenieDniOtgruzki;
    @ManyToOne
    @JoinColumn(name = "scheben_id")
    private Scheben scheben;
    @ManyToOne
    @JoinColumn(name = "karier_id")
    private Karier karier;
    @ManyToOne
    @JoinColumn(name = "voditel_id")
    private Voditel voditel;
    @ManyToOne
    @JoinColumn(name = "stroiObject_id")
    private StroiObject stroiObject;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @OneToOne
    @JoinColumn(name = "ttn_id")
    private Ttn ttn;
    private int kmBazaToKarier;
    private int kmKarierToStroiObject;
    private int kmStroiObjectToBaza;
    private int kmStroiObjectToKarierNext;
    @Enumerated(EnumType.STRING)
    private StatusReis statusReis;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private BigDecimal sum;
    @OneToMany(targetEntity = ReisDetails.class, cascade = CascadeType.ALL)
    private List<ReisDetails> details;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Smena> smenas;



    public Reis(Principal principal) {
    }
}
