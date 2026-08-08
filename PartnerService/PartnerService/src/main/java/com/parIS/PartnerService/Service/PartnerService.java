package com.parIS.PartnerService.Service;

import com.parIS.PartnerService.Client.BankClient;
import com.parIS.PartnerService.DTOs.PartnerRequest;
import com.parIS.PartnerService.DTOs.PartnerResponse;
import com.parIS.PartnerService.Models.Partner;
import com.parIS.PartnerService.Mapper.PartnerMapper;
import com.parIS.PartnerService.Exception.PartnerNotFoundException;
import com.parIS.PartnerService.Repository.PartnerRepo;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;  //Resilenece 4J


import java.util.List;

@Service
public class PartnerService {

    private final PartnerRepo repo;
    private final PartnerMapper mapper;
    private final BankClient bankClient;

    public PartnerService(PartnerRepo repo, PartnerMapper mapper,BankClient bankClient) {
        this.repo = repo;
        this.mapper = mapper;
        this.bankClient = bankClient;
    }
//    List<Partner> partners = new ArrayList<>(Arrays.asList
//            (new Partner(1L, "Individual", "khushi", "dixit",
//            "2003-01-01", "khushalidixit5@gmail.com", "Married"),
//                    new Partner(2L, "Business", "rahul", "sharma",
//                            "2006-09-01", "rahulsharma@gmail.com", "Single"))
//            );


//    public List<Partner> getPartner() {
//        return partners;
//    }

    public List<Partner> getPartner() {
        return repo.findAll();
    }

    //    public Partner getPartnerbyID(Long id) {
//        for (Partner p : partners) {
//            if (p.getId().equals(id))
//                return p;
//        }
//        throw new RuntimeException("Partner not found");
//    }

    @Retry(name = "bankService")
    @CircuitBreaker(name = "bankService",fallbackMethod = "bankServiceFallback")
    @RateLimiter(name = "bankService", fallbackMethod = "bankServiceFallback")
    public PartnerResponse getPartnerbyID(Long PartnerId) {

        Partner partner = repo.findById(PartnerId)
                .orElseThrow(() ->
                        new PartnerNotFoundException("Partner not found with id " + PartnerId));

        PartnerResponse response = mapper.toResponse(partner);

        System.out.println("Calling Bank Service...");

        response.setBankDetails(bankClient.getBankDetails(PartnerId));

        return response;
    }

    public PartnerResponse bankServiceFallback(Long partnerId, Exception ex) {

        System.out.println("Fallback Executed : " + ex.getClass().getName());

        Partner partner = repo.findById(partnerId)
                .orElseThrow(() ->
                        new PartnerNotFoundException("Partner not found"));

        PartnerResponse response = mapper.toResponse(partner);

        response.setBankDetails(List.of());

        return response;
    }

    //    public void addPartner(Partner partner)
//    {
//        partners.add(partner);
//    }
    public Partner addPartner(PartnerRequest request)
    {
        Partner partner = mapper.toEntity(request);
        return repo.save(partner);
    }
    //    public void updatePartner(Partner partner)
//    {
//        int index=0;
//        for(int i=0;i<partners.size();i++)
//        {
//            if(partners.get(i).getId().equals(partner.getId()))
//             index=i;
//        }
//        partners.set(index,partner);
//    }
    public Partner updatePartner(Long PartnerId,PartnerRequest request)
    {
        Partner partner=repo.findById(PartnerId)
                .orElseThrow(()-> new
                        PartnerNotFoundException("Partner not found with id"));
        partner.setFirstname(request.getFirstname());
        partner.setLastname(request.getLastname());
        partner.setDateOfBirth(request.getDateOfBirth());
        partner.setEmail(request.getEmail());
        partner.setMartialStatus(request.getMartialStatus());
        partner.setPartnertype(request.getPartnerType());
        return repo.save(partner);
    }
    //    public void deletePartner(Long id)
//    {
//        int index=0;
//        for(int i=0;i<partners.size();i++)
//        {
//            if(partners.get(i).getId().equals(id))
//                index=i;
//        }
//        partners.remove(index);
//    }
    public void deletePartner(Long PartnerId)
    {
        Partner partner=repo.findById(PartnerId).orElseThrow(()->
                new PartnerNotFoundException("Partner not found with Id" + PartnerId));
        repo.deleteById(PartnerId);
    }

}


