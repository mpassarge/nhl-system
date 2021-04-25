package com.passargecorp.nhl.entity.mappers;

import static com.passargecorp.nhl.entity.mappers.CommonMappers.teamInfoDtoToTeamInfoEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.passargecorp.nhl.dto.standings.RecordsDto;
import com.passargecorp.nhl.dto.standings.StandingsDto;
import com.passargecorp.nhl.dto.standings.TeamRecords;
import com.passargecorp.nhl.entity.standings.DivisionStandingsEntity;
import com.passargecorp.nhl.entity.standings.TeamStatsEntity;

public final class StandingsEntityMapper {

    public static DivisionStandingsEntity standingsDtoToDivisionStandingsEntityList(final StandingsDto standings) {
        final Map<String, List<TeamStatsEntity>> map = new HashMap<>();
        for (RecordsDto record : standings.getRecords()) {
            map.put(createKey(record.getDivision().getName()), teamRecordsToTeamStatsEntity(record.getTeamRecords()));
        }
        return new DivisionStandingsEntity(map);
    }

    private static List<TeamStatsEntity> teamRecordsToTeamStatsEntity(final List<TeamRecords> teamRecords) {
        return teamRecords.stream().map(StandingsEntityMapper::teamRecordToTeamStatsEntity).collect(Collectors.toList());
    }

    private static TeamStatsEntity teamRecordToTeamStatsEntity(final TeamRecords teamRecords) {
        return new TeamStatsEntity(teamInfoDtoToTeamInfoEntity(teamRecords.getTeam()), teamRecords.getPoints(), teamRecords.getGamesPlayed());
    }

    private static String createKey(final String key) {
        return key.toLowerCase().replace(" ", "-");
    }
}
