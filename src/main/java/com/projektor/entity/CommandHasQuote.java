package com.projektor.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "command_has_quote")
public class CommandHasQuote {
    @EmbeddedId
    private CommandHasQuoteId id;

    @MapsId("commandId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "command_id", nullable = false)
    private Command command;

    @MapsId("quoteId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "quote_id", nullable = false)
    private Quote quote;

    public CommandHasQuoteId getId() {
        return id;
    }

    public void setId(CommandHasQuoteId id) {
        this.id = id;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

}