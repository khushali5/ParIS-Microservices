package com.parIS.PartnerService.Controller;
import com.parIS.PartnerService.Models.Contact;
import com.parIS.PartnerService.Service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partner/{PartnerId}/contact")
public class ContactController {
    @Autowired
    private ContactService service;

    @GetMapping
    public List<Contact> getContactbyPartnerId(@PathVariable Long PartnerId)
    {
        return service.getContactbyPartnerId(PartnerId);
    }

    @PostMapping
    public Contact addContact(@PathVariable Long PartnerId,
                              @Valid @RequestBody Contact contact)
    {
        return service.addContact(PartnerId,contact);
    }

    @PutMapping("/{ContactId}")
    public Contact updateContact(@PathVariable Long PartnerId,@PathVariable Long ContactId,
                                 @Valid @RequestBody Contact contact)
    {
        return service.updateContact(PartnerId,ContactId,contact);
    }

    @DeleteMapping("/{ContactId}")
    public void deleteContact(@PathVariable Long PartnerId,
                              @PathVariable Long ContactId)
    {
        service.deleteContact(PartnerId,ContactId);
    }
}

