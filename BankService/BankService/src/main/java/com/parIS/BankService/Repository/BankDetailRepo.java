package com.parIS.BankService.Repository;

import com.parIS.BankService.Models.BankDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankDetailRepo extends JpaRepository<BankDetail, Long> {

    List<BankDetail> findByPartnerId(Long partnerId);

}
