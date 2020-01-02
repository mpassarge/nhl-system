package com.passargecorp.nhl.entity.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class GameEntity {

    private String gamePk;
    private StatusEntity status;
    private TeamsEntity teams;
}
