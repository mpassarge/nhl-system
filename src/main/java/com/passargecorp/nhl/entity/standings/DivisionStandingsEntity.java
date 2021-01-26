package com.passargecorp.nhl.entity.standings;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class DivisionStandingsEntity {

    private String name;
    private List<TeamStatsEntity> teamStats;

}
