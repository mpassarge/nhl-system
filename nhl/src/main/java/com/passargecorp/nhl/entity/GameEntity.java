package com.passargecorp.nhl.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class GameEntity {

    private String gamePk;
    private StatusEntity status;
    private TeamsEntity teams;
}
