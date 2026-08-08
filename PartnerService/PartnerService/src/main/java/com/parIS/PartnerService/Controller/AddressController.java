package com.parIS.PartnerService.Controller;

import com.parIS.PartnerService.Models.Address;
import com.parIS.PartnerService.Service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partner/{PartnerId}/address")
public class AddressController {
    @Autowired
    private AddressService service;

    @GetMapping
    public List<Address> getAddressByPartnerId(@PathVariable Long PartnerId) {
        return service.getAddressbyPartnerID(PartnerId);
    }

    @PostMapping
    public Address addAddress(@PathVariable Long PartnerId,
                              @Valid @RequestBody Address address) {
        return service.addAddress(PartnerId, address);
    }

    @PutMapping("/{AddressId}")
    public Address updateAddress(@PathVariable Long PartnerId,
                                 @PathVariable Long AddressId,
                                 @Valid @RequestBody Address address) {
        return service.updateAddress(PartnerId, AddressId, address);
    }


    @DeleteMapping("/{AddressId}")
    public void deleteAddress(@PathVariable Long PartnerId,
                              @PathVariable Long AddressId) {
        service.deleteAddress(PartnerId, AddressId);
    }
}

