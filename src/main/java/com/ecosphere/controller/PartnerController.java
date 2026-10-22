package com.ecosphere.controller;

import com.ecosphere.model.Partner;
import com.ecosphere.service.PartnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partners")
public class PartnerController {
    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping
    public ResponseEntity<List<Partner>> getAll() {
        return ResponseEntity.ok(partnerService.getAll());
    }

    @PostMapping
    public ResponseEntity<Partner> create(@RequestBody Partner partner) {
        return ResponseEntity.ok(partnerService.create(partner));
    }
}
