package mariusz.szmagara.cookbook.user.address.model;

import mariusz.szmagara.cookbook.user.model.User;

import javax.persistence.*;


@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String streetFlatAndHouseNumber;
    private String postalCode;
    private String city;
    @OneToOne
    private User user;

    public Address() {
    }

    public Address(String streetFlatAndHouseNumber, String postalCode, String city) {
        this.streetFlatAndHouseNumber = streetFlatAndHouseNumber;
        this.postalCode = postalCode;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetFlatAndHouseNumber() {
        return streetFlatAndHouseNumber;
    }

    public void setStreetFlatAndHouseNumber(String streetFlatAndHouseNumber) {
        this.streetFlatAndHouseNumber = streetFlatAndHouseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
