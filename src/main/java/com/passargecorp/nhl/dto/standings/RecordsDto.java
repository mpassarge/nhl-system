package com.passargecorp.nhl.dto.standings;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RecordsDto {

    private String standingsType;
    private DivisionsDto division;
    private List<TeamRecords> teamRecords;
}
