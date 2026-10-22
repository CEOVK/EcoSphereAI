package com.ecosphere.service;

import com.ecosphere.model.Partner;
import com.ecosphere.repository.PartnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerService {
    private final PartnerRepository partnerRepository;

    public PartnerService(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    public List<Partner> getAll() {
        return partnerRepository.findAll();
    }

    public Partner create(Partner partner) {
        return partnerRepository.save(partner);
    }
}
