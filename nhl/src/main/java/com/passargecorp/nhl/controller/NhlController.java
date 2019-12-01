package com.passargecorp.nhl.controller;

import java.util.regex.Pattern;

import com.passargecorp.nhl.dto.schedule.ScheduleDto;
import com.passargecorp.nhl.dto.team.TeamWrapperDto;
import com.passargecorp.nhl.repository.NhlRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/nhl")
public class NhlController {

    private static final Pattern DATE_PATTERN = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
    private NhlRepository nhlRepository;

    @GetMapping("/schedule")
    public ResponseEntity<ScheduleDto> getScheduleByDate(@RequestParam final String date) {

        // Validate Date Pattern
        if (!DATE_PATTERN.matcher(date).find()) {
            throw new IllegalArgumentException(date);
        }

        return ResponseEntity.ok(nhlRepository.getScheduleByDate(date));
    }

    @GetMapping("/teams")
    public ResponseEntity<TeamWrapperDto> getTeams() {
        return ResponseEntity.ok(nhlRepository.getTeams());
    }
}