package com.parIS.BankService.Controller;

import com.parIS.BankService.DTOs.BankDetailRequestDTO;
import com.parIS.BankService.DTOs.BankDetailResponseDTO;
import com.parIS.BankService.Service.BankDetailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank-details")
public class BankController {

    @Autowired
    private BankDetailService bankDetailService;


    @PostMapping
    public ResponseEntity<BankDetailResponseDTO> createBankDetail(
            @Valid @RequestBody BankDetailRequestDTO requestDTO) {
        BankDetailResponseDTO response = bankDetailService.createBankDetail(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankDetailResponseDTO> getBankDetailById(@PathVariable Long id) {
        BankDetailResponseDTO response = bankDetailService.getBankDetailById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<BankDetailResponseDTO>> getAllBankDetails() {
        return ResponseEntity.ok(bankDetailService.getAllBankDetails());
    }

    @GetMapping("/partner/{partnerId}")
    public ResponseEntity<List<BankDetailResponseDTO>> getBankDetailsByPartnerId(
            @PathVariable Long partnerId) {

        return ResponseEntity.ok(bankDetailService.getBankDetailsByPartnerId(partnerId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankDetailResponseDTO> updateBankDetail(
            @PathVariable Long id,
            @Valid @RequestBody BankDetailRequestDTO requestDTO) {
        BankDetailResponseDTO response = bankDetailService.updateBankDetail(id, requestDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankDetail(@PathVariable Long id) {
        bankDetailService.deleteBankDetail(id);
        return ResponseEntity.noContent().build();
    }
}