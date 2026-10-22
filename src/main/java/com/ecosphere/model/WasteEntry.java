package com.ecosphere.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "waste_entries")
public class WasteEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemType;
    private String category;
    private Double weight;
    private String condition;
    private String serialNumber;
    private String qrId;
    private LocalDate collectionDate;
    private String studentName;
    private String className;
    private String collectionPoint;
    private String status;

    public WasteEntry() {}

    public WasteEntry(String itemType, String category, Double weight, String condition, String serialNumber,
                     String qrId, LocalDate collectionDate, String studentName, String className,
                     String collectionPoint, String status) {
        this.itemType = itemType;
        this.category = category;
        this.weight = weight;
        this.condition = condition;
        this.serialNumber = serialNumber;
        this.qrId = qrId;
        this.collectionDate = collectionDate;
        this.studentName = studentName;
        this.className = className;
        this.collectionPoint = collectionPoint;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getItemType() { return itemType; }
    public void setItemType(String itemType) { this.itemType = itemType; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }
    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }
    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    public String getQrId() { return qrId; }
    public void setQrId(String qrId) { this.qrId = qrId; }
    public LocalDate getCollectionDate() { return collectionDate; }
    public void setCollectionDate(LocalDate collectionDate) { this.collectionDate = collectionDate; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
    public String getCollectionPoint() { return collectionPoint; }
    public void setCollectionPoint(String collectionPoint) { this.collectionPoint = collectionPoint; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
