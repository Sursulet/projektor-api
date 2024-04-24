package com.projektor.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "quote")
public class Quote {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "supposed_start_date", nullable = false)
    private Instant supposedStartDate;

    @Column(name = "supposed_end_date")
    private Instant supposedEndDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "provider", nullable = false)
    private User provider;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "task", nullable = false)
    private Task task;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Instant getSupposedStartDate() {
        return supposedStartDate;
    }

    public void setSupposedStartDate(Instant supposedStartDate) {
        this.supposedStartDate = supposedStartDate;
    }

    public Instant getSupposedEndDate() {
        return supposedEndDate;
    }

    public void setSupposedEndDate(Instant supposedEndDate) {
        this.supposedEndDate = supposedEndDate;
    }

    public User getProvider() {
        return provider;
    }

    public void setProvider(User provider) {
        this.provider = provider;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

}