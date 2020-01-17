package com.passargecorp.nhl.entity.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class StatusEntity {

    private String detailedState;
    private int statusCode;
}
