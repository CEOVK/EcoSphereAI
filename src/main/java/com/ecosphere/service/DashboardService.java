package com.ecosphere.service;

import com.ecosphere.model.Event;
import com.ecosphere.model.Partner;
import com.ecosphere.model.Project;
import com.ecosphere.model.WasteEntry;
import com.ecosphere.repository.EventRepository;
import com.ecosphere.repository.PartnerRepository;
import com.ecosphere.repository.ProjectRepository;
import com.ecosphere.repository.WasteRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService {
    private final WasteRepository wasteRepository;
    private final ProjectRepository projectRepository;
    private final EventRepository eventRepository;
    private final PartnerRepository partnerRepository;

    public DashboardService(WasteRepository wasteRepository,
                           ProjectRepository projectRepository,
                           EventRepository eventRepository,
                           PartnerRepository partnerRepository) {
        this.wasteRepository = wasteRepository;
        this.projectRepository = projectRepository;
        this.eventRepository = eventRepository;
        this.partnerRepository = partnerRepository;
    }

    public Map<String, Object> getOverview() {
        List<WasteEntry> waste = wasteRepository.findAll();
        List<Project> projects = projectRepository.findAll();
        List<Event> events = eventRepository.findAll();
        List<Partner> partners = partnerRepository.findAll();

        double totalWaste = waste.stream().mapToDouble(e -> e.getWeight() == null ? 0 : e.getWeight()).sum();
        int activeStudents = (int) waste.stream().map(WasteEntry::getStudentName).filter(s -> s != null && !s.isBlank()).distinct().count();
        int projectsBuilt = (int) projects.stream().filter(p -> p.getStatus() != null && !p.getStatus().equalsIgnoreCase("Idea")).count();
        int workshopsConducted = (int) events.stream().filter(e -> e.getType() != null && e.getType().equalsIgnoreCase("Workshop")).count();
        int sustainabilityIndex = Math.min(97, (int) (totalWaste * 2 + projectsBuilt * 3 + workshopsConducted * 4));

        Map<String, Object> overview = new HashMap<>();
        overview.put("totalWasteCollected", Math.round(totalWaste * 100.0) / 100.0);
        overview.put("monthlyCollection", Math.round(totalWaste * 0.65 * 100.0) / 100.0);
        overview.put("quarterlyCollection", Math.round(totalWaste * 1.3 * 100.0) / 100.0);
        overview.put("annualCollection", Math.round(totalWaste * 2.1 * 100.0) / 100.0);
        overview.put("activeStudents", activeStudents);
        overview.put("projectsBuilt", projectsBuilt);
        overview.put("workshopsConducted", workshopsConducted);
        overview.put("environmentalImpactScore", Math.min(100, sustainabilityIndex));
        overview.put("sustainabilityIndex", sustainabilityIndex);
        overview.put("wasteEntries", waste);
        overview.put("projects", projects);
        overview.put("events", events);
        overview.put("partners", partners);
        return overview;
    }
}
