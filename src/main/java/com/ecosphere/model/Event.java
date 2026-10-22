package com.ecosphere.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private int attendance;
    private int hours;
    private String impact;
    private LocalDate date;

    public Event() {}

    public Event(String name, String type, int attendance, int hours, String impact, LocalDate date) {
        this.name = name;
        this.type = type;
        this.attendance = attendance;
        this.hours = hours;
        this.impact = impact;
        this.date = date;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public int getAttendance() { return attendance; }
    public void setAttendance(int attendance) { this.attendance = attendance; }
    public int getHours() { return hours; }
    public void setHours(int hours) { this.hours = hours; }
    public String getImpact() { return impact; }
    public void setImpact(String impact) { this.impact = impact; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
