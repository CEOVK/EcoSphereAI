package com.ecosphere.controller;

import com.ecosphere.model.Project;
import com.ecosphere.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAll() {
        return ResponseEntity.ok(projectService.getAll());
    }

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.create(project));
    }

    @GetMapping("/suggest")
    public ResponseEntity<Map<String, List<String>>> suggest(@RequestParam String component) {
        return ResponseEntity.ok(Map.of("ideas", projectService.suggestProjectIdeas(component)));
    }
}
