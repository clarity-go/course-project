package edu.kashp.SOSmodel;

import java.time.LocalDateTime;
import java.util.Objects;

public class InsuranceType {
    private String id;
    private String name;
    private double karman;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public InsuranceType() {
    }

    public InsuranceType(String name, double karman, String description) {
        this.name = name;
        this.karman = karman;
        this.description = description;
    }

    public InsuranceType(String id, String name, double karman, String description, LocalDateTime createdAt,
                         LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.karman = karman;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getKarman() {
        return karman;
    }

    public void setKarman(double karman) {
        this.karman = karman;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuranceType that = (InsuranceType) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "InsuranceType{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", karman=" + karman +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
