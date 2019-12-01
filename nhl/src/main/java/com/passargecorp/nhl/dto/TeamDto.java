package com.passargecorp.nhl.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {

    private int score;
    private TeamInfoDto team;

    public int getScore() {
        return score;
    }

    public TeamInfoDto getTeam() {
        return team;
    }
}
