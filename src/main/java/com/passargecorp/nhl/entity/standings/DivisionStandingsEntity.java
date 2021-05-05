package com.passargecorp.nhl.entity.standings;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
//@NoArgsConstructor
@Getter
@ToString
public class DivisionStandingsEntity {

    private final String divisionName;
    private final List<TeamStatsEntity> teams;
}
