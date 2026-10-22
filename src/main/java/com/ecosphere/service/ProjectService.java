package com.ecosphere.service;

import com.ecosphere.model.Project;
import com.ecosphere.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public Project create(Project project) {
        if (project.getStatus() == null || project.getStatus().isBlank()) {
            project.setStatus("Idea");
        }
        return projectRepository.save(project);
    }

    public List<String> suggestProjectIdeas(String component) {
        String normalized = component == null ? "" : component.trim().toLowerCase();

        return switch (normalized) {
            case "motor" -> Arrays.asList("RC Car", "Mini Fan", "Robot Arm");
            case "battery" -> Arrays.asList("Solar Bank", "Sensor Node", "Portable Charger");
            case "motherboard" -> Arrays.asList("Hardware Study", "Tech Art Display", "Component Recovery");
            case "ssd" -> Arrays.asList("AI Learning Kit", "IoT Sensor Base", "Data Logger");
            case "fan" -> Arrays.asList("Ventilation Prototype", "Automated Cooling System", "Wind Energy Model");
            default -> Arrays.asList("STEM Prototype", "Sustainable Device Model", "Smart Reuse Concept");
        };
    }
}
