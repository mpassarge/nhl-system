package com.passargecorp.nhl.dto.standings;

import com.passargecorp.nhl.dto.schedule.TeamDto;
import com.passargecorp.nhl.dto.schedule.TeamInfoDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TeamRecords {

    private TeamInfoDto team;
    public int points;

    public TeamInfoDto getTeam() {
        return team;
    }

    public int getPoints() {
        return points;
    }
}
