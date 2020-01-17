package com.passargecorp.nhl.entity.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class TeamEntity {

    private int score;
    private TeamInfoEntity team;
}
