package com.passargecorp.nhl.dto.standings;

import com.passargecorp.nhl.dto.schedule.TeamInfoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TeamRecords {

    public TeamInfoDto team;
    public int points;
    public int gamesPlayed;
}
