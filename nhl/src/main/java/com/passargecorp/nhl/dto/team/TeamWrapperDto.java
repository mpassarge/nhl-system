package com.passargecorp.nhl.dto.team;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TeamWrapperDto {

    private List<TeamInfoDto> teams;
}
