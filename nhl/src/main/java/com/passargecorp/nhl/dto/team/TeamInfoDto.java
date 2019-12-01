package com.passargecorp.nhl.dto.team;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TeamInfoDto {

    private int id;
    private String abbreviation;
    private String name;

    public int getId() {
        return id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }
}
