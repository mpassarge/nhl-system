package com.passargecorp.nhl.entity.standings;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class DivisionStandingsEntity {

    @JsonUnwrapped
    private Map<String, List<TeamStatsEntity>> teamStats;
}
