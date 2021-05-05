package com.passargecorp.nhl.service;

import java.util.List;

import com.passargecorp.nhl.dto.schedule.GameDateDto;
import com.passargecorp.nhl.dto.schedule.ScheduleDto;
import com.passargecorp.nhl.dto.standings.StandingsDto;
import com.passargecorp.nhl.entity.mappers.GameEntityMappers;
import com.passargecorp.nhl.entity.mappers.StandingsEntityMapper;
import com.passargecorp.nhl.entity.schedule.GameEntity;
import com.passargecorp.nhl.entity.standings.StandingsEntity;
import com.passargecorp.nhl.repository.NhlRepository;
import com.passargecorp.nhl.repository.ScheduleGameCacheRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NhlService {

    private static final Logger logger = LoggerFactory.getLogger(NhlService.class);
    private static final String STANDINGS_CACHE = "standings";

    private final ScheduleGameCacheRepository gameCacheRepository;
    private final NhlRepository nhlRepository;

    public List<GameEntity> getGamesByDate(final String date) {

        if (gameCacheRepository.contains(date)) {
            return gameCacheRepository.getGameEntity(date);
        }

        final ScheduleDto scheduleDto = nhlRepository.getScheduleByDate(date);
        validateScheduleDto(scheduleDto);

        final List<GameEntity> games = GameEntityMappers.gameDtosToGameEntities(scheduleDto.getGameDates().get(0).getGames());

        gameCacheRepository.addGameEntity(date, games);

        return games;
    }

    @Cacheable(STANDINGS_CACHE)
    public StandingsEntity getDivisionStandings() {
        final StandingsDto standingsDto = nhlRepository.getStandings();
        return StandingsEntityMapper.standingsDtoToStandingsEntity(standingsDto);
    }

    @CacheEvict(allEntries = true, value = STANDINGS_CACHE)
    @Scheduled(cron = "0 7 * * * *", zone = "America/New_York")
    public void clearCache() {
    }

    private void validateScheduleDto(final ScheduleDto scheduleDto) {
        final List<GameDateDto> gameDates = scheduleDto.getGameDates();
        // Must only be a  single gameDate;
        final int gameDatesSize = gameDates.size();
        Validate.isTrue(gameDatesSize == 1, "", gameDatesSize);
    }
}
