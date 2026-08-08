package com.parIS.PartnerService.Repository;

import com.parIS.PartnerService.Models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepo extends JpaRepository<Contact,Long> {

    List<Contact> findByPartnerId(Long partnerId);
}
