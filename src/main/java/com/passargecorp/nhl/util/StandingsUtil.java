package com.passargecorp.nhl.util;

import java.util.Arrays;
import java.util.List;

public final class StandingsUtil {

    private static final List<String> CENTRAL_DIVISIONS_KEYS = Arrays.asList("discover-central", "central");
    private static final List<String> EAST_DIVISIONS_KEYS = Arrays.asList("massmutual-east", "east");
    private static final List<String> NORTH_DIVISIONS_KEYS = Arrays.asList("scotia-north", "north");
    private static final List<String> WEST_DIVISIONS_KEYS = Arrays.asList("honda-west", "west");
    private static final List<List<String>> DIVISION_KEYS = Arrays.asList(CENTRAL_DIVISIONS_KEYS, EAST_DIVISIONS_KEYS, NORTH_DIVISIONS_KEYS, WEST_DIVISIONS_KEYS);

//    public static List<TeamStatsEntity> getTeamStatsEntityFromDivision(final String division, final DivisionStandingsEntity divisionStandingsEntity) {
//        final List<String> keys = DIVISION_KEYS.stream().filter(l -> l.contains(division)).findFirst().orElseThrow(RuntimeException::new);
//        return divisionStandingsEntity.getTeamStats().get(keys.get(0));
//    }
}
