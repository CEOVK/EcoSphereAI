package com.ecosphere.model;

import jakarta.persistence.*;

@Entity
@Table(name = "partners")
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String focusArea;
    private String sector;

    public Partner() {}

    public Partner(String name, String type, String focusArea, String sector) {
        this.name = name;
        this.type = type;
        this.focusArea = focusArea;
        this.sector = sector;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getFocusArea() { return focusArea; }
    public void setFocusArea(String focusArea) { this.focusArea = focusArea; }
    public String getSector() { return sector; }
    public void setSector(String sector) { this.sector = sector; }
}
