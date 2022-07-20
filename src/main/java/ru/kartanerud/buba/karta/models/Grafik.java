package ru.kartanerud.buba.karta.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import ru.kartanerud.buba.karta.util.EntityIdResolver;

import javax.persistence.*;

@Data
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        scope = Grafik.class,
        resolver = EntityIdResolver.class,
        property = "id"
)
public class Grafik implements ComboListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String dateSmena;
    private String pnDay;
    private String vtDay;
    private String srDay;
    private String chtDay;
    private String pytDay;
    private String sbDay;
    private String vsDay;

    @ManyToOne
    @JsonIdentityReference
    @JsonSerialize(as=ComboListItem.class)
    private Model model;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private VoditelWeb voditelWeb;

    @Override
    @JsonIgnore
    public String getRepr() {
        return String.format("%s %s", voditelWeb.getName(), name);
    }
}
