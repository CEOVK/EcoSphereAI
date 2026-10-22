package com.ecosphere.controller;

import com.ecosphere.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ai")
public class AiController {
    private final ProjectService projectService;

    public AiController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/suggest")
    public ResponseEntity<Map<String, List<String>>> suggest(@RequestParam String component) {
        return ResponseEntity.ok(Map.of("ideas", projectService.suggestProjectIdeas(component)));
    }
}
