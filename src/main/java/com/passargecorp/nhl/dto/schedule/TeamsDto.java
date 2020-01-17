package com.passargecorp.nhl.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TeamsDto {

    private TeamDto away;
    private TeamDto home;

    public TeamDto getAway() {
        return away;
    }

    public TeamDto getHome() {
        return home;
    }
}
