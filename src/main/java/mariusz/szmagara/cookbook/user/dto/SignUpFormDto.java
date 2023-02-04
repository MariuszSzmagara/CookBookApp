package mariusz.szmagara.cookbook.user.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class SignUpFormDto {
    @NotEmpty(message = "{pl.javastart.cookbook.user.model.User.firstName.NotEmpty.message}")
    @Size(min = 3, message = "{pl.javastart.cookbook.user.model.User.firstName.Size.message}")
    private String firstName;
    @NotEmpty(message = "{pl.javastart.cookbook.user.model.User.lastName.NotEmpty.message}")
    @Size(min = 3, message = "{pl.javastart.cookbook.user.model.User.lastName.Size.message}")
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "{pl.javastart.cookbook.user.model.User.dateOfBirth.Past.message}")
    private LocalDate dateOfBirth;
    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "{pl.javastart.cookbook.user.model.User.emailAddress.Email.message}")
    private String emailAddress;
    private boolean signedUpForNewsletter;
    @NotEmpty(message = "{pl.javastart.cookbook.user.model.User.userName.NotEmpty.message}")
    private String userName;
    @NotEmpty(message = "{pl.javastart.cookbook.user.model.User.password.NotEmpty.message}")
    @Length(min = 8, message = "{pl.javastart.cookbook.user.model.User.password.Length.message}")
    @Pattern.List({
            @Pattern(regexp = "^(?=.*[a-z]).*$", message = "PASSWORD has to have at least one lower case letter!"),
            @Pattern(regexp = "^(?=.*[A-Z]).*$", message = "PASSWORD has to have at least one upper case letter!"),
            @Pattern(regexp = "^(?=.*[@#$%&!-_]).*$", message = "PASSWORD has to have at least one special character!")
    })
    private String password;
    private String passwordResetKey;
    @AssertTrue(message = ("{pl.javastart.cookbook.user.model.User.agreedToTermsAndConditions.AssertTrue.message}"))
    private boolean agreedToTermsAndConditions;
    @NotEmpty(message = "{pl.javastart.cookbook.user.address.model.Address.streetFlatAndHouseNumber.NotEmpty.message}")
    private String streetFlatAndHouseNumber;
    @NotEmpty(message = "{pl.javastart.cookbook.user.address.model.Address.postalCode.NotEmpty.message}")
    @Pattern(regexp = "^\\d{2}[- ]?\\d{3}$", message = "POSTAL CODE has to have format: 00-000")
    private String postalCode;
    @NotEmpty(message = "{pl.javastart.cookbook.user.address.model.Address.city.NotEmpty.message}")
    private String city;

    public SignUpFormDto() {
    }

    public SignUpFormDto(String firstName, String lastName, LocalDate dateOfBirth,
                         String emailAddress, boolean signedUpForNewsletter, String userName,
                         String password, String passwordResetKey, boolean agreedToTermsAndConditions,
                         String streetFlatAndHouseNumber, String postalCode, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.signedUpForNewsletter = signedUpForNewsletter;
        this.userName = userName;
        this.password = password;
        this.passwordResetKey = passwordResetKey;
        this.agreedToTermsAndConditions = agreedToTermsAndConditions;
        this.streetFlatAndHouseNumber = streetFlatAndHouseNumber;
        this.postalCode = postalCode;
        this.city = city;
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
}
