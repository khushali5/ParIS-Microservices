package com.parIS.BankService.Mapper;

import com.parIS.BankService.DTOs.BankDetailRequestDTO;
import com.parIS.BankService.DTOs.BankDetailResponseDTO;
import com.parIS.BankService.Models.BankDetail;

public class BankDetailMapper {

    public static BankDetail toEntity(BankDetailRequestDTO dto) {
        BankDetail bankDetail = new BankDetail();
        bankDetail.setBankName(dto.getBankName());
        bankDetail.setAccountNumber(dto.getAccountNumber());
        bankDetail.setIfscCode(dto.getIfscCode());
        bankDetail.setPartnerId(dto.getPartnerId());
        return bankDetail;
    }

    public static BankDetailResponseDTO toResponseDTO(BankDetail entity) {
        String masked = maskAccountNumber(entity.getAccountNumber());
        return new BankDetailResponseDTO(
                entity.getBankId(),
                entity.getBankName(),
                masked,
                entity.getIfscCode(),
                entity.getPartnerId()
        );
    }

    private static String maskAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.length() <= 4) {
            return accountNumber;
        }
        int visibleDigits = 4;
        String lastDigits = accountNumber.substring(accountNumber.length() - visibleDigits);
        return "X".repeat(accountNumber.length() - visibleDigits) + lastDigits;
    }
}