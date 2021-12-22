package ru.kartanerud.buba.karta.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kartanerud.buba.karta.models.enamy.karier.Oblast;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Karier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 25, message = "Не меньше 3, но не более 25 букв")
    private String karierName;
    private String karierAddress;
    private String karierLawFace;
    private String lawAddress;

    @Email(message = "Не верный ввод Email")
    private String email;
    private String coordinates;
    private String inn;

    @Enumerated(EnumType.STRING)
    private Oblast oblast;
    private String nomerLicenzia;
    private String dataLicenzia;
    private String grafikRabota;
    private String nalichieVesov;
    private String contactObshiy;
    private String contactDiretor;
    private String contactVesovaya;
    private String dopContact;
    private String commentOpen;
    private String commentClose;
    private String kodZhd;

    @OneToMany(mappedBy = "karier", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Scheben> schebens = new ArrayList<>();

    public void addSchebenToKarier(Scheben scheben) {
        scheben.setKarier(this);
        schebens.add(scheben);
    }

    public void removeScheben(Scheben scheben) {schebens.remove(scheben);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Karier karier = (Karier) o;
        return Objects.equals(id, karier.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}