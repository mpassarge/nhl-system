package com.passargecorp.nhl.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class GameDto {

    private String gamePk;
    private StatusDto status;
    private TeamsDto teams;

    public String getGamePk() {
        return gamePk;
    }

    public StatusDto getStatus() {
        return status;
    }

    public TeamsDto getTeams() {
        return teams;
    }
}
