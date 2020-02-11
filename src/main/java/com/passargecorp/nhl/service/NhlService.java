package com.passargecorp.nhl.service;

import java.util.List;

import com.passargecorp.nhl.dto.schedule.GameDateDto;
import com.passargecorp.nhl.dto.schedule.ScheduleDto;
import com.passargecorp.nhl.entity.schedule.GameEntity;
import com.passargecorp.nhl.entity.mappers.GameEntityMappers;
import com.passargecorp.nhl.repository.ScheduleGameCacheRepository;
import com.passargecorp.nhl.repository.NhlRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NhlService {

    private static final Logger logger = LoggerFactory.getLogger(NhlService.class);

    private ScheduleGameCacheRepository gameCacheRepository;
    private NhlRepository nhlRepository;

    public List<GameEntity> getGamesByDate(final String date){

        if(gameCacheRepository.contains(date)){
            return gameCacheRepository.getGameEntity(date);
        }

        final ScheduleDto scheduleDto = nhlRepository.getScheduleByDate(date);
        validateScheduleDto(scheduleDto);

        final List<GameEntity> games = GameEntityMappers.gameDtosToGameEntities(scheduleDto.getGameDates().get(0).getGames());

        gameCacheRepository.addGameEntity(date, games);

        return games;
    }

    private void validateScheduleDto(final ScheduleDto scheduleDto) {
        final List<GameDateDto> gameDates = scheduleDto.getGameDates();

        // Must only be a  single gameDate;
        final int gameDatesSize = gameDates.size();
        Validate.isTrue(gameDatesSize == 1, "", gameDatesSize);
    }
}
