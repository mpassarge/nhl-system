package com.passargecorp.nhl.entity.mappers;

import com.passargecorp.nhl.dto.schedule.TeamInfoDto;
import com.passargecorp.nhl.entity.schedule.TeamInfoEntity;

public class CommonMappers {

    public static TeamInfoEntity teamInfoDtoToTeamInfoEntity(final TeamInfoDto teamInfo) {
        return new TeamInfoEntity(teamInfo.getId(), teamInfo.getName());
    }
}
