package com.passargecorp.nhl.entity.mappers;

import static com.passargecorp.nhl.entity.mappers.CommonMappers.teamInfoDtoToTeamInfoEntity;

import java.util.List;
import java.util.stream.Collectors;

import com.passargecorp.nhl.dto.schedule.GameDto;
import com.passargecorp.nhl.dto.schedule.StatusDto;
import com.passargecorp.nhl.dto.schedule.TeamDto;
import com.passargecorp.nhl.dto.schedule.TeamsDto;
import com.passargecorp.nhl.entity.schedule.GameEntity;
import com.passargecorp.nhl.entity.schedule.StatusEntity;
import com.passargecorp.nhl.entity.schedule.TeamEntity;
import com.passargecorp.nhl.entity.schedule.TeamsEntity;

public class GameEntityMappers {

    public static List<GameEntity> gameDtosToGameEntities(final List<GameDto> games){
        return games.stream().map(GameEntityMappers::gameDtoToGameEntity).collect(Collectors.toList());
    }

    private static GameEntity gameDtoToGameEntity(final GameDto game){
        return new GameEntity(game.getGamePk(), statusDtoToStatusEntity(game.getStatus()), teamsDtoToTeamsEntity(game.getTeams()));
    }

    private static TeamsEntity teamsDtoToTeamsEntity(final TeamsDto teams) {
        return new TeamsEntity(teamDtoToTeamEntity(teams.getAway()), teamDtoToTeamEntity(teams.getHome()));
    }

    private static TeamEntity teamDtoToTeamEntity(final TeamDto team) {
        return new TeamEntity(team.getScore(), teamInfoDtoToTeamInfoEntity(team.getTeam()));
    }

    private static StatusEntity statusDtoToStatusEntity(final StatusDto status) {
        return new StatusEntity(status.getDetailedState(), status.getStatusCode());
    }
}
