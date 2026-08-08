package com.parIS.PartnerService.Mapper;
import com.parIS.PartnerService.DTOs.ContactRequest;
import com.parIS.PartnerService.DTOs.ContactResponse;
import com.parIS.PartnerService.Models.Contact;
import com.parIS.PartnerService.Models.Partner;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    // DTO -> Entity
    public Contact toEntity(
            ContactRequest request,
            Partner partner) {

        Contact contact = new Contact();

        contact.setContactType(
                request.getContactType());

        contact.setContactValue(
                request.getContactValue());

        contact.setPartner(partner);

        return contact;
    }

    // Entity -> DTO
    public ContactResponse toResponse(
            Contact contact) {

        ContactResponse response =
                new ContactResponse();

        response.setContactId(
                contact.getContactId());

        response.setContactType(
                contact.getContactType());

        response.setContactValue(
                contact.getContactValue());

        if(contact.getPartner() != null) {

            response.setPartnerId(
                    contact.getPartner().getId());

            response.setPartnerName(
                    contact.getPartner().getFirstname()
                            + " " +
                            contact.getPartner().getLastname()
            );
        }

        return response;
    }
}

