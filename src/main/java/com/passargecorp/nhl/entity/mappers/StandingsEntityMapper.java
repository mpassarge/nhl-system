package com.passargecorp.nhl.entity.mappers;

import static com.passargecorp.nhl.entity.mappers.CommonMappers.teamInfoDtoToTeamInfoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.passargecorp.nhl.dto.standings.RecordsDto;
import com.passargecorp.nhl.dto.standings.StandingsDto;
import com.passargecorp.nhl.dto.standings.TeamRecords;
import com.passargecorp.nhl.entity.standings.DivisionStandingsEntity;
import com.passargecorp.nhl.entity.standings.StandingsEntity;
import com.passargecorp.nhl.entity.standings.TeamStatsEntity;

public final class StandingsEntityMapper {

    public static StandingsEntity standingsDtoToStandingsEntity(final StandingsDto standingsDto) {
        final List<DivisionStandingsEntity> divisionStandings = new ArrayList<>();
        for (final RecordsDto recordsDto : standingsDto.getRecords()) {
            divisionStandings.add(new DivisionStandingsEntity(createKey(recordsDto.getDivision().getName()), teamRecordsToTeamStatsEntity(recordsDto.getTeamRecords())));
        }
        return new StandingsEntity(divisionStandings);
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
