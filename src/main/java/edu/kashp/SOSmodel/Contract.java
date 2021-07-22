package edu.kashp.SOSmodel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Contract {
    private String id;
    private String name;
    private LocalDate date;
    private int sum;
    private double tarif;
    private Agent agent;
    private InsuranceType type;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Contract() {
    }

    public Contract(String name, LocalDate date, int sum, double tarif, Agent agent, InsuranceType type,
                    String description) {
        this.name = name;
        this.date = date;
        this.sum = sum;
        this.tarif = tarif;
        this.agent = agent;
        this.type = type;
        this.description = description;
    }

    public Contract(String id, String name, LocalDate date, int sum, double tarif, Agent agent,
                    InsuranceType type, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.sum = sum;
        this.tarif = tarif;
        this.agent = agent;
        this.type = type;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public InsuranceType getType() {
        return type;
    }

    public void setType(InsuranceType type) {
        this.type = type;
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
        Contract contract = (Contract) o;
        return getId().equals(contract.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", sum=" + sum +
                ", tarif=" + tarif +
                ", agent=" + agent +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
