package com.parIS.PartnerService.Repository;

import com.parIS.PartnerService.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AddressRepo extends JpaRepository<Address,Long> {

    List<Address> findByPartnerId(Long partnerId);
}

