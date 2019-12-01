package com.passargecorp.nhl.dto.team;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class TeamWrapperDto {

    private List<TeamInfoDto> teams;

    public List<TeamInfoDto> getTeams() {
        return teams;
    }
}
