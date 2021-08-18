package com.example.product;

public class ProductDecresed extends AbstractEvent {
    
    String eventType;
    Long id;
    int amt;
    int stock;

    public ProductDecresed() {
        this.eventType = this.getClass().getSimpleName();
    }

    public String getEventType() {
        return this.eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmt() {
        return this.amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
