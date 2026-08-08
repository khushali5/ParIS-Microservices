package com.parIS.PartnerService.Models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Partner",uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PartnerId;

    @NotBlank(message = "Partner type must not be blank")
    @Pattern(regexp = "INDIVIDUAL|FAMILY",message = "Partner type must be indidual or family")
    private String partnertype;

    @NotBlank(message = "First name must not be blank")
    private String firstname;

    @NotBlank(message = "Last name must not be blank")
    private String lastname;

    @NotBlank(message = "Date of birth must not be blank")
    private String dateOfBirth;

    @NotBlank(message = "Email must not be blank")
    private String email;

    @NotBlank(message = "Please give your marital status")
    private String martialStatus;

    public Partner() {
    }

    public Partner(Long PartnerId, String partnertype, String firstname,
                   String lastname, String dateOfBirth,
                   String email, String martialStatus) {

        this.PartnerId = PartnerId;
        this.partnertype = partnertype;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.martialStatus = martialStatus;
    }

    public Long getId() {
        return PartnerId;
    }

    public void setId(Long PartnerId) {
        this.PartnerId = PartnerId;
    }

    public String getPartnertype() {
        return partnertype;
    }

    public void setPartnertype(String partnertype) {
        this.partnertype = partnertype;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }
}

