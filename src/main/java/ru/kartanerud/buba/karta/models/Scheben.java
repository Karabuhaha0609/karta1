package ru.kartanerud.buba.karta.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kartanerud.buba.karta.models.enamy.scheben.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Scheben {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Gost gost;
    @Enumerated(EnumType.STRING)
    private VidScheben vidScheben;
    @Enumerated(EnumType.STRING)
    private Frakcia frakcia;
    @Enumerated(EnumType.STRING)
    private MarkaProchnosti markaProchnosti;
    private String nasypnayaPlotnost;
    private String soderzhanieIlistyh;
    @Enumerated(EnumType.STRING)
    private Morozostoikost morozostoikost;
    @Enumerated(EnumType.STRING)
    private Radioaktivnost radioaktivnost;
    private String slabyePorody;
    @Enumerated(EnumType.STRING)
    private Leshadnost leshadnost;
    @Enumerated(EnumType.STRING)
    private MarkaPoIsteraemosti markaPoIsteraemosti;
    private String cvet;
    private BigDecimal price;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "products_categories",
            joinColumns = @JoinColumn(name = "scheben_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private Karier karier;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scheben scheben = (Scheben) o;
        return Objects.equals(id, scheben.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
