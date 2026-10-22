package com.ecosphere.model;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String category;
    private String materialsUsed;
    private String recoveredComponents;
    private String mentor;
    private String status;

    public Project() {}

    public Project(String title, String description, String category, String materialsUsed,
                  String recoveredComponents, String mentor, String status) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.materialsUsed = materialsUsed;
        this.recoveredComponents = recoveredComponents;
        this.mentor = mentor;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getMaterialsUsed() { return materialsUsed; }
    public void setMaterialsUsed(String materialsUsed) { this.materialsUsed = materialsUsed; }
    public String getRecoveredComponents() { return recoveredComponents; }
    public void setRecoveredComponents(String recoveredComponents) { this.recoveredComponents = recoveredComponents; }
    public String getMentor() { return mentor; }
    public void setMentor(String mentor) { this.mentor = mentor; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
