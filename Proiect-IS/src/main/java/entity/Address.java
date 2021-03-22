package entity;

import javax.persistence.*;
import javax.print.DocFlavor;

@Entity
@Table (name = "address")
public class Address {

    @Id
    private String idAddress;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private int nr;

    @OneToOne(mappedBy = "address")
    private User user;

    public Address(String country, String city, String street, int nr)
    {
        this.country = country;
        this.city = city;
        this.street = street;
        this.nr = nr;
    }

    public Address(){}

    public String getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(String idAddress) {
        this.idAddress = idAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }
}
