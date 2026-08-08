package com.parIS.PartnerService.Mapper;
import com.parIS.PartnerService.DTOs.PartnerRequest;
import com.parIS.PartnerService.DTOs.PartnerResponse;
import com.parIS.PartnerService.Models.Partner;
import org.springframework.stereotype.Component;

@Component
public class PartnerMapper {

    // Request DTO -> Entity
    public Partner toEntity(PartnerRequest request) {

        Partner partner = new Partner();

        partner.setPartnertype(request.getPartnerType());
        partner.setFirstname(request.getFirstname());
        partner.setLastname(request.getLastname());
        partner.setDateOfBirth(request.getDateOfBirth());
        partner.setEmail(request.getEmail());
        partner.setMartialStatus(request.getMartialStatus());

        return partner;
    }

    // Entity -> Response DTO
    public PartnerResponse toResponse(Partner partner) {

        PartnerResponse response = new PartnerResponse();

        response.setPartnerId(partner.getId());
        response.setPartnerType(partner.getPartnertype());
        response.setFirstname(partner.getFirstname());
        response.setLastname(partner.getLastname());
        response.setDateOfBirth(partner.getDateOfBirth());
        response.setEmail(partner.getEmail());
        response.setMartialStatus(partner.getMartialStatus());

        return response;
    }
}


