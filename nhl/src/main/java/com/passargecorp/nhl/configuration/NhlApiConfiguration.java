package com.passargecorp.nhl.configuration;

import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
@ConfigurationProperties(prefix = "api")
@PropertySource("classpath:nhl/webservice.properties")
@NoArgsConstructor
public class NhlApiConfiguration {

    private String url;
    private String schedule;
    private String team;

    // TODO: find out how to do constructor injection

    public void setUrl(final String url) {
        this.url = url;
    }

    public void setSchedule(final String schedule) {
        this.schedule = schedule;
    }

    public void setTeam(final String team) {
        this.team = team;
    }

    public String getScheduleWithDate(final String date) {
        return UriComponentsBuilder.fromHttpUrl(getScheduleUrl()).queryParam("date", date).toUriString();
    }

    public String getTeam() {
        return UriComponentsBuilder.fromHttpUrl(getTeamUrl()).toUriString();
    }

    private String getScheduleUrl() {
        return url + schedule;
    }

    private String getTeamUrl() {
        return url + team;
    }
}
