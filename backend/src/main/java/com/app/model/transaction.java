package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;
    private String from;
    private String to;
    private String value;
    private String hash;

    // Constructors
    public Transaction() {}
    public Transaction(String from, String to, String value, String hash) {
        this.from = from;
        this.to = to;
        this.value = value;
        this.hash = hash;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }
    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    public String getHash() { return hash; }
    public void setHash(String hash) { this.hash = hash; }
}
