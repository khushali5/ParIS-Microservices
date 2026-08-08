package com.parIS.PartnerService.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PartnerResponse {


    private Long PartnerId;
    private String firstname;
    private String lastname;
    private String dateOfBirth;
    private String email;
    private String martialStatus;
    private String partnerType;
    private List<BankDTO> bankDetails;


    public Long getPartnerId() {
        return PartnerId;
    }

    public void setPartnerId(Long partnerId) {
        PartnerId = partnerId;
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

    public String getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(String partnerType) {
        this.partnerType = partnerType;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public List<BankDTO> getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(List<BankDTO> bankDetails) {
        this.bankDetails = bankDetails;
    }
}


