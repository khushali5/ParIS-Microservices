package com.parIS.BankService.DTOs;

public class BankDetailResponseDTO {

    private Long bankId;
    private String bankName;
    private String maskedAccountNumber;
    private String ifscCode;
    private Long partnerId;

    public BankDetailResponseDTO() {
    }

    public BankDetailResponseDTO(Long bankId, String bankName, String maskedAccountNumber,
                                 String ifscCode, Long partnerId) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.maskedAccountNumber = maskedAccountNumber;
        this.ifscCode = ifscCode;
        this.partnerId = partnerId;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getMaskedAccountNumber() {
        return maskedAccountNumber;
    }

    public void setMaskedAccountNumber(String maskedAccountNumber) {
        this.maskedAccountNumber = maskedAccountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }
}