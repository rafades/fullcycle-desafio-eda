package com.consumer.balance.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BalanceUpdatedDTO {
    
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Payload")
    private BalanceUpdatedPayloadDTO payload;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BalanceUpdatedPayloadDTO getPayload() {
        return payload;
    }
    public void setPayload(BalanceUpdatedPayloadDTO payload) {
        this.payload = payload;
    }    
}
