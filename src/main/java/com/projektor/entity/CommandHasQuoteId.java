package com.projektor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class CommandHasQuoteId implements java.io.Serializable {
    private static final long serialVersionUID = 9148808521804505351L;
    @Column(name = "command_id", nullable = false)
    private Integer commandId;

    @Column(name = "quote_id", nullable = false)
    private Integer quoteId;

    public Integer getCommandId() {
        return commandId;
    }

    public void setCommandId(Integer commandId) {
        this.commandId = commandId;
    }

    public Integer getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Integer quoteId) {
        this.quoteId = quoteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CommandHasQuoteId entity = (CommandHasQuoteId) o;
        return Objects.equals(this.commandId, entity.commandId) &&
                Objects.equals(this.quoteId, entity.quoteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commandId, quoteId);
    }

}