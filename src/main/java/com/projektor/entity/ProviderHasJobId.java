package com.projektor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class ProviderHasJobId implements java.io.Serializable {
    private static final long serialVersionUID = -8123392242081468532L;
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "jobs_id", nullable = false)
    private Integer jobsId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getJobsId() {
        return jobsId;
    }

    public void setJobsId(Integer jobsId) {
        this.jobsId = jobsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProviderHasJobId entity = (ProviderHasJobId) o;
        return Objects.equals(this.userId, entity.userId) &&
                Objects.equals(this.jobsId, entity.jobsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, jobsId);
    }

}