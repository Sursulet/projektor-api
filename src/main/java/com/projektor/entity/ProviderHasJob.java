package com.projektor.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "provider_has_jobs")
public class ProviderHasJob {
    @EmbeddedId
    private ProviderHasJobId id;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @MapsId("jobsId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "jobs_id", nullable = false)
    private Job jobs;

    public ProviderHasJobId getId() {
        return id;
    }

    public void setId(ProviderHasJobId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Job getJobs() {
        return jobs;
    }

    public void setJobs(Job jobs) {
        this.jobs = jobs;
    }

}