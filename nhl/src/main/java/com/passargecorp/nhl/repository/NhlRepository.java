package com.passargecorp.nhl.repository;

import com.passargecorp.nhl.configuration.NhlApiConfiguration;
import com.passargecorp.nhl.dto.ScheduleDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class NhlRepository {

    private final NhlApiConfiguration nhlApiConfiguration;
    private final RestTemplate restTemplate;

    public NhlRepository(final NhlApiConfiguration nhlApiConfiguration, final RestTemplateBuilder restTemplateBuilder) {
        this.nhlApiConfiguration = nhlApiConfiguration;
        this.restTemplate = restTemplateBuilder.build();
    }

    public ScheduleDto getScheduleByDate(final String date) {
        return restTemplate.getForObject(nhlApiConfiguration.getScheduleWithDate(date), ScheduleDto.class);
    }
}