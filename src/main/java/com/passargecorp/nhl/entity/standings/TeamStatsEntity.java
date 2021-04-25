package com.passargecorp.nhl.entity.standings;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.passargecorp.nhl.entity.schedule.TeamInfoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class TeamStatsEntity {

    @JsonUnwrapped
    private TeamInfoEntity teamInfo;
    private int points;
    private int gamesPlayed;
}
