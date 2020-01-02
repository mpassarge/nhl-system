package com.passargecorp.nhl.controller;

import java.util.List;

import com.passargecorp.nhl.dto.team.TeamWrapperDto;
import com.passargecorp.nhl.entity.schedule.GameEntity;
import com.passargecorp.nhl.repository.NhlRepository;
import com.passargecorp.nhl.service.NhlService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/nhl")
public class NhlController {

    private static final String DATE_PATTERN_STRING = "[0-9]{4}-[0-9]{2}-[0-9]{2}";

    private NhlRepository nhlRepository;
    private NhlService nhlService;

    @GetMapping("/games")
    public ResponseEntity<List<GameEntity>> getScheduleByDate(@RequestParam final String date) {

        // Validate Date Pattern
        Validate.matchesPattern(date, DATE_PATTERN_STRING, "Date does not match pattern", date);

        return ResponseEntity.ok(nhlService.getGamesByDate(date));
    }

    @GetMapping("/teams")
    public ResponseEntity<TeamWrapperDto> getTeams() {
        return ResponseEntity.ok(nhlRepository.getTeams());
    }
}