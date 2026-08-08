package com.parIS.PartnerService.Client;

import com.parIS.PartnerService.DTOs.BankDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "BANK-SERVICE")
public interface BankClient {

    @GetMapping("/partner/{partnerId}/bankdetails")
    List<BankDTO> getBankDetails(@PathVariable("partnerId") Long partnerId);

}