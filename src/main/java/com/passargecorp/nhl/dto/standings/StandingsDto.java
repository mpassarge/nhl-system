package com.passargecorp.nhl.dto.standings;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
public class StandingsDto {

    private List<RecordsDto> records;

    public List<RecordsDto> getRecords() {
        return records;
    }
}
