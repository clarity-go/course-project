package edu.kashp.SOSmodel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Salary {
    private String id;
    private Agent agent;
    private LocalDate from;
    private LocalDate to;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Salary() {
    }

    public Salary(Agent agent, LocalDate from, LocalDate to, String description) {
        this.agent = agent;
        this.from = from;
        this.to = to;
        this.description = description;
    }

    public Salary(String id, Agent agent, LocalDate from, LocalDate to, String description,
                  LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.agent = agent;
        this.from = from;
        this.to = to;
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

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
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
        Salary salary = (Salary) o;
        return getId().equals(salary.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id='" + id + '\'' +
                ", agent=" + agent +
                ", from=" + from +
                ", to=" + to +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
