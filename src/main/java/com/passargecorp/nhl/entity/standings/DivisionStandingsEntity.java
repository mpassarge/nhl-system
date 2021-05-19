package com.passargecorp.nhl.entity.standings;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class DivisionStandingsEntity {

    private final String divisionName;
    private final int id;
    private final List<TeamStatsEntity> teams;
}
