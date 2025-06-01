package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "gasdata")
public class GasData {
    @Id
    private String id;
    private double gasPrice;
    private String timestamp;

    // Constructors
    public GasData() {}
    public GasData(double gasPrice, String timestamp) {
        this.gasPrice = gasPrice;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getId() { return id; }
    public double getGasPrice() { return gasPrice; }
    public void setGasPrice(double gasPrice) { this.gasPrice = gasPrice; }
    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}
