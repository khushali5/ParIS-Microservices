package com.parIS.PartnerService.Mapper;
import com.parIS.PartnerService.DTOs.AddressRequest;
import com.parIS.PartnerService.DTOs.AddressResponse;
import com.parIS.PartnerService.Models.Address;
import com.parIS.PartnerService.Models.Partner;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    // Request DTO -> Entity
    public Address toEntity(AddressRequest request, Partner partner) {

        Address address = new Address();

        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setCountry(request.getCountry());
        address.setPartner(partner);

        return address;
    }

    // Entity -> Response DTO
    public AddressResponse toResponse(Address address) {

        AddressResponse response = new AddressResponse();

        response.setAddressId(address.getAddressId());
        response.setStreet(address.getStreet());
        response.setCity(address.getCity());
        response.setCountry(address.getCountry());

        if(address.getPartner() != null) {

            response.setPartnerId(address.getPartner().getId());

            response.setPartnerName(
                    address.getPartner().getFirstname()
                            + " " +
                            address.getPartner().getLastname()
            );
        }

        return response;
    }
}
