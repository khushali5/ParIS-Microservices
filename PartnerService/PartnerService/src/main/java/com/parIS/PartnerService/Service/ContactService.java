package com.parIS.PartnerService.Service;
import com.parIS.PartnerService.Models.Contact;
import com.parIS.PartnerService.Models.Partner;
//import com.parIS.PartnerService.PartnerNotFoundException;
import com.parIS.PartnerService.Exception.PartnerNotFoundException;
import com.parIS.PartnerService.Repository.ContactRepo;
import com.parIS.PartnerService.Repository.PartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepo repo;

    @Autowired
    private PartnerRepo partnerRepo;

    public List<Contact> getContactbyPartnerId(Long partnerId) {
        return repo.findByPartnerId(partnerId);
    }

    public Contact addContact(Long PartnerId, Contact contact) {
        Partner partner = partnerRepo.findById(PartnerId).
                orElseThrow(()->new PartnerNotFoundException("Partner not found"+ PartnerId));

        contact.setPartner(partner);
        return repo.save(contact);

    }

    public Contact updateContact(Long PartnerId,Long ContactId,Contact contact)
    {
        Partner partner = partnerRepo.findById(PartnerId).
                orElseThrow(()->new PartnerNotFoundException("Partner not found" + PartnerId));
        Contact existing = repo.findById(ContactId).
                orElseThrow(()->new RuntimeException("ContactId not found"));

        existing.setContactType(contact.getContactType());
        existing.setContactValue(contact.getContactValue());

        existing.setPartner(partner);
        return repo.save(existing);
    }

    public  void deleteContact(Long PartnerId,Long ContactId)
    {
        repo.deleteById(ContactId);
    }
}

