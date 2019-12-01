package com.passargecorp.nhl.dto.schedule;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class GameDateDto {

    private String date;
    private List<GameDto> games;

    public String getDate() {
        return date;
    }

    public List<GameDto> getGames() {
        return games;
    }
}