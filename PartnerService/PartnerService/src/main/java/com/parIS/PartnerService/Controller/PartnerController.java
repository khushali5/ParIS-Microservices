package com.parIS.PartnerService.Controller;
import com.parIS.PartnerService.DTOs.PartnerRequest;
import com.parIS.PartnerService.DTOs.PartnerResponse;
import com.parIS.PartnerService.Models.Partner;
import com.parIS.PartnerService.Mapper.PartnerMapper;
import com.parIS.PartnerService.Service.PartnerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partner")
public class PartnerController {

    private final PartnerService service;
    private final PartnerMapper mapper;

    public PartnerController(PartnerService service,
                             PartnerMapper mapper) {

        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<PartnerResponse> getPartner() {

        List<Partner> partners = service.getPartner();

        return partners.stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public PartnerResponse getPartnerbyID(@PathVariable Long id) {

        return service.getPartnerbyID(id);

    }

    @PostMapping
    public PartnerResponse addPartner(
            @Valid @RequestBody PartnerRequest request) {

        Partner partner = service.addPartner(request);

        return mapper.toResponse(partner);
    }

    @PutMapping("/{id}")
    public PartnerResponse updatePartner(
            @PathVariable Long id,
            @Valid @RequestBody PartnerRequest request) {

        Partner partner = service.updatePartner(id, request);

        return mapper.toResponse(partner);
    }

    @DeleteMapping("/{id}")
    public void deletePartner(@PathVariable Long id) {

        service.deletePartner(id);
    }
}
