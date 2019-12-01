package com.passargecorp.nhl.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class StatusDto {

    private String detailedState;
    private int statusCode;

    public String getDetailedState() {
        return detailedState;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
