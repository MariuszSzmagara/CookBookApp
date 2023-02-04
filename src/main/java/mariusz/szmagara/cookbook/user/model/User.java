package mariusz.szmagara.cookbook.user.model;

import org.springframework.format.annotation.DateTimeFormat;
import mariusz.szmagara.cookbook.user.address.model.Address;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "users")
// user is keyword/reserved word in h2 database
// so in application-development.properties - spring.datasource.url=jdbc:h2:mem:testdb;NON_KEYWORDS=USER
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private String emailAddress;
    private boolean signedUpForNewsletter;
    private String userName;
    private String password;
    private String passwordResetKey;
    private boolean agreedToTermsAndConditions;
    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<Role> roles;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;

    public User() {
    }

    public User(String firstName, String lastName, LocalDate dateOfBirth,
                String emailAddress, boolean signedUpForNewsletter, String userName,
                String password, String passwordResetKey, boolean agreedToTermsAndConditions) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.signedUpForNewsletter = signedUpForNewsletter;
        this.userName = userName;
        this.password = password;
        this.passwordResetKey = passwordResetKey;
        this.agreedToTermsAndConditions = agreedToTermsAndConditions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isSignedUpForNewsletter() {
        return signedUpForNewsletter;
    }

    public void setSignedUpForNewsletter(boolean signedUpForNewsletter) {
        this.signedUpForNewsletter = signedUpForNewsletter;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordResetKey() {
        return passwordResetKey;
    }

    public void setPasswordResetKey(String passwordResetKey) {
        this.passwordResetKey = passwordResetKey;
    }

    public boolean isAgreedToTermsAndConditions() {
        return agreedToTermsAndConditions;
    }

    public void setAgreedToTermsAndConditions(boolean agreedToTermsAndConditions) {
        this.agreedToTermsAndConditions = agreedToTermsAndConditions;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
