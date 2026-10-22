package com.ecosphere.repository;

import com.ecosphere.model.WasteEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteRepository extends JpaRepository<WasteEntry, Long> {
}
