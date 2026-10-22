package com.ecosphere.controller;

import com.ecosphere.model.WasteEntry;
import com.ecosphere.service.WasteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/waste")
public class WasteController {
    private final WasteService wasteService;

    public WasteController(WasteService wasteService) {
        this.wasteService = wasteService;
    }

    @GetMapping
    public ResponseEntity<List<WasteEntry>> getAll() {
        return ResponseEntity.ok(wasteService.getAll());
    }

    @PostMapping
    public ResponseEntity<WasteEntry> create(@RequestBody WasteEntry wasteEntry) {
        return ResponseEntity.ok(wasteService.create(wasteEntry));
    }

    @GetMapping("/total")
    public ResponseEntity<Map<String, Double>> total() {
        return ResponseEntity.ok(Map.of("total", wasteService.getTotalCollected()));
    }
}
