package com.ecosphere.service;

import com.ecosphere.model.Project;
import com.ecosphere.model.WasteEntry;
import com.ecosphere.repository.ProjectRepository;
import com.ecosphere.repository.WasteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class WasteService {
    private final WasteRepository wasteRepository;

    public WasteService(WasteRepository wasteRepository) {
        this.wasteRepository = wasteRepository;
    }

    public List<WasteEntry> getAll() {
        return wasteRepository.findAll();
    }

    public WasteEntry create(WasteEntry wasteEntry) {
        if (wasteEntry.getCollectionDate() == null) {
            wasteEntry.setCollectionDate(LocalDate.now());
        }
        if (wasteEntry.getStatus() == null || wasteEntry.getStatus().isBlank()) {
            wasteEntry.setStatus("Received");
        }
        if (wasteEntry.getQrId() == null || wasteEntry.getQrId().isBlank()) {
            wasteEntry.setQrId("EW-" + System.currentTimeMillis());
        }
        return wasteRepository.save(wasteEntry);
    }

    public double getTotalCollected() {
        return wasteRepository.findAll().stream().mapToDouble(e -> e.getWeight() == null ? 0 : e.getWeight()).sum();
    }
}
