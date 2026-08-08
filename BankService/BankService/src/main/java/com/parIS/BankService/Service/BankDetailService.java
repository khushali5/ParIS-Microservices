package com.parIS.BankService.Service;

import com.parIS.BankService.DTOs.BankDetailRequestDTO;
import com.parIS.BankService.DTOs.BankDetailResponseDTO;
import com.parIS.BankService.Exception.BankNotFoundException;
import com.parIS.BankService.Mapper.BankDetailMapper;
import com.parIS.BankService.Models.BankDetail;
import com.parIS.BankService.Repository.BankDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankDetailService {

    @Autowired
    private BankDetailRepo bankDetailRepo;

    public BankDetailResponseDTO createBankDetail(BankDetailRequestDTO requestDTO) {
        BankDetail entity = BankDetailMapper.toEntity(requestDTO);
        BankDetail saved = bankDetailRepo.save(entity);
        return BankDetailMapper.toResponseDTO(saved);
    }

    public BankDetailResponseDTO getBankDetailById(Long id) {
        BankDetail entity = bankDetailRepo.findById(id)
                .orElseThrow(() -> new BankNotFoundException("Bank detail not found with id: " + id));
        return BankDetailMapper.toResponseDTO(entity);
    }

    public List<BankDetailResponseDTO> getAllBankDetails() {
        return bankDetailRepo.findAll()
                .stream()
                .map(BankDetailMapper::toResponseDTO)
                .toList();
    }

    public List<BankDetailResponseDTO> getBankDetailsByPartnerId(Long partnerId) {
        return bankDetailRepo.findByPartnerId(partnerId)
                .stream()
                .map(BankDetailMapper::toResponseDTO)
                .toList();
    }

    public BankDetailResponseDTO updateBankDetail(Long id, BankDetailRequestDTO requestDTO) {
        BankDetail existing = bankDetailRepo.findById(id)
                .orElseThrow(() -> new BankNotFoundException("Bank detail not found with id: " + id));

        existing.setBankName(requestDTO.getBankName());
        existing.setAccountNumber(requestDTO.getAccountNumber());
        existing.setIfscCode(requestDTO.getIfscCode());
        existing.setPartnerId(requestDTO.getPartnerId());

        BankDetail updated = bankDetailRepo.save(existing);
        return BankDetailMapper.toResponseDTO(updated);
    }

    public void deleteBankDetail(Long id) {
        BankDetail existing = bankDetailRepo.findById(id)
                .orElseThrow(() -> new BankNotFoundException("Bank detail not found with id: " + id));
        bankDetailRepo.delete(existing);
    }
}