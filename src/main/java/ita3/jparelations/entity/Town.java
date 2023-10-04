package ita3.jparelations.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int zipCode;
    private String mayour;
    private int schools;

    @OneToMany(mappedBy = "town", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    Set<Citizen> citizens;

    public Town() {
    }

    public Town(String name, int zipCode, String mayour, int schools) {
        this.name = name;
        this.zipCode = zipCode;
        this.mayour = mayour;
        this.schools = schools;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getMayour() {
        return mayour;
    }

    public void setMayour(String mayour) {
        this.mayour = mayour;
    }

    public int getSchools() {
        return schools;
    }

    public void setSchools(int schools) {
        this.schools = schools;
    }


}
