package com.passargecorp.nhl.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class TeamsEntity {

    private TeamEntity away;
    private TeamEntity home;
}
