package com.parIS.PartnerService.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ContactId;

    @NotBlank(message = "Contact type is required")
    private String contactType;

    @NotBlank(message = "Contact value is required")
    private String contactValue;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PartnerId",nullable = false)
    private Partner partner;

    public Contact() {
    }

    public Contact(Long ContactId, String contactType, String contactValue) {
        this.ContactId = ContactId;
        this.contactType = contactType;
        this.contactValue = contactValue;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContactValue() {
        return contactValue;
    }

    public void setContactValue(String contactValue) {
        this.contactValue = contactValue;
    }

    public Long getContactId() {
        return ContactId;
    }

    public void setContactId(Long contactId) {
        ContactId = contactId;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }
}
