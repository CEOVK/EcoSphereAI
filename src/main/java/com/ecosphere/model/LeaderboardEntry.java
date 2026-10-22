package com.ecosphere.model;

import jakarta.persistence.*;

@Entity
@Table(name = "leaderboard")
public class LeaderboardEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private String className;
    private int points;
    private String badge;

    public LeaderboardEntry() {}

    public LeaderboardEntry(String studentName, String className, int points, String badge) {
        this.studentName = studentName;
        this.className = className;
        this.points = points;
        this.badge = badge;
    }

    public Long getId() { return id; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }
    public String getBadge() { return badge; }
    public void setBadge(String badge) { this.badge = badge; }
}
