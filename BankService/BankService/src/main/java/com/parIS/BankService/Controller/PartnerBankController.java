package com.parIS.BankService.Controller;

import com.parIS.BankService.DTOs.BankDetailResponseDTO;
import com.parIS.BankService.Service.BankDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partner")
public class PartnerBankController {

    @Autowired
    private BankDetailService bankDetailService;

    @GetMapping("/{PartnerId}/bankdetails")
    public List<BankDetailResponseDTO> getBankDetailsByPartnerId(@PathVariable Long PartnerId)
    {
        return bankDetailService.getBankDetailsByPartnerId(PartnerId);
    }
}
