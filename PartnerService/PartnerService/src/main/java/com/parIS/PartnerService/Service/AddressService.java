package com.parIS.PartnerService.Service;

import com.parIS.PartnerService.Models.Address;
import com.parIS.PartnerService.Models.Partner;
import com.parIS.PartnerService.Exception.PartnerNotFoundException;
import com.parIS.PartnerService.Repository.AddressRepo;
import com.parIS.PartnerService.Repository.PartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepo repo;
    @Autowired
    private PartnerRepo repo1;

    public List<Address> getAddressbyPartnerID(Long PartnerId)
    {
        return repo.findByPartnerId(PartnerId);
    }


    public Address addAddress(Long PartnerId,Address address)
    {
        Partner partner = repo1.findById(PartnerId)
                .orElseThrow(() -> new PartnerNotFoundException("Partner not found" + PartnerId));

        address.setPartner(partner);
        return repo.save(address);
    }

    public Address updateAddress(Long PartnerId,Long AddressId,Address address)
    {
        Partner partner = repo1.findById(PartnerId)
                .orElseThrow(() -> new PartnerNotFoundException("Partner not found with id" + PartnerId));
        Address existing = repo.findById(AddressId)
                .orElseThrow(() -> new RuntimeException("Address not found"));

        existing.setStreet(address.getStreet());
        existing.setCity(address.getCity());
        existing.setCountry(address.getCountry());

        existing.setPartner(partner);
        return repo.save(existing);
    }

    public void deleteAddress(Long PartnerId,Long AddressId)
    {
        repo.deleteById(AddressId);
    }


}

