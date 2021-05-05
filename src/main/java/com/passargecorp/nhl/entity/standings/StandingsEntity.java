package com.passargecorp.nhl.entity.standings;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class StandingsEntity {

    @JsonUnwrapped
    private final List<DivisionStandingsEntity> standings;
}
