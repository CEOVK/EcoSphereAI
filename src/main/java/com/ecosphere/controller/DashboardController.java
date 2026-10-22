package com.ecosphere.controller;

import com.ecosphere.model.Project;
import com.ecosphere.model.WasteEntry;
import com.ecosphere.service.DashboardService;
import com.ecosphere.service.ProjectService;
import com.ecosphere.service.WasteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DashboardController {
    private final DashboardService dashboardService;
    private final WasteService wasteService;
    private final ProjectService projectService;

    public DashboardController(DashboardService dashboardService, WasteService wasteService, ProjectService projectService) {
        this.dashboardService = dashboardService;
        this.wasteService = wasteService;
        this.projectService = projectService;
    }

    @GetMapping("/dashboard/overview")
    public ResponseEntity<Map<String, Object>> overview() {
        return ResponseEntity.ok(dashboardService.getOverview());
    }

    @GetMapping("/dashboard/metrics")
    public ResponseEntity<Map<String, Object>> metrics() {
        Map<String, Object> overview = dashboardService.getOverview();
        return ResponseEntity.ok(Map.of(
            "totalWasteCollected", overview.get("totalWasteCollected"),
            "activeStudents", overview.get("activeStudents"),
            "projectsBuilt", overview.get("projectsBuilt"),
            "workshopsConducted", overview.get("workshopsConducted"),
            "sustainabilityIndex", overview.get("sustainabilityIndex")
        ));
    }
}
