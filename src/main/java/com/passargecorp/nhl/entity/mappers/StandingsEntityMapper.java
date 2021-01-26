package com.passargecorp.nhl.entity.mappers;

import static com.passargecorp.nhl.entity.mappers.CommonMappers.teamInfoDtoToTeamInfoEntity;

import java.util.List;
import java.util.stream.Collectors;

import com.passargecorp.nhl.dto.standings.RecordsDto;
import com.passargecorp.nhl.dto.standings.StandingsDto;
import com.passargecorp.nhl.dto.standings.TeamRecords;
import com.passargecorp.nhl.entity.standings.DivisionStandingsEntity;
import com.passargecorp.nhl.entity.standings.TeamStatsEntity;

public class StandingsEntityMapper {

    public static List<DivisionStandingsEntity> standingsDtoToDivisionStandingsEntityList(final StandingsDto standings) {
        return standings.getRecords().stream().map(StandingsEntityMapper::recordsDtoToTeamStatsEntity).collect(Collectors.toList());
    }

    private static DivisionStandingsEntity recordsDtoToTeamStatsEntity(final RecordsDto record) {
        return new DivisionStandingsEntity(record.getDivision().getName(), teamRecordsToTeamStatsEntity(record.getTeamRecords()));
    }

    private static List<TeamStatsEntity> teamRecordsToTeamStatsEntity(final List<TeamRecords> teamRecords) {
        return teamRecords.stream().map(StandingsEntityMapper::teamRecordToTeamStatsEntity).collect(Collectors.toList());
    }

    private static TeamStatsEntity teamRecordToTeamStatsEntity(final TeamRecords teamRecords) {
        return new TeamStatsEntity(teamInfoDtoToTeamInfoEntity(teamRecords.getTeam()), teamRecords.getPoints());
    }
}
