package com.passargecorp.nhl.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.passargecorp.nhl.entity.schedule.GameEntity;
import org.springframework.lang.Nullable;

public class ScheduleGameCacheRepository {

    private Map<String, List<GameEntity>> gameEntityMap = new HashMap<>();

    public boolean contains(final String date){
        return gameEntityMap.containsKey(date);
    }

    @Nullable
    public List<GameEntity> getGameEntity(final String date){
        return gameEntityMap.get(date);
    }

    public void addGameEntity(final String date, final List<GameEntity> games){

        if(gameEntityMap.size() > 5){
            gameEntityMap.clear();
        }

        gameEntityMap.put(date, games);
    }
}
