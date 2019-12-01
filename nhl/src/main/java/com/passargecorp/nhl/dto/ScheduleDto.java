package com.passargecorp.nhl.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDto {

    @JsonProperty("dates")
    private List<GameDateDto> gameDates;

    public List<GameDateDto> getGameDates() {
        return gameDates;
    }
}
