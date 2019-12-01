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

    // TODO: find out how to do constructor injection

    public void setUrl(final String url) {
        this.url = url;
    }

    public void setSchedule(final String schedule) {
        this.schedule = schedule;
    }

    public String getScheduleWithDate(final String date) {
        return UriComponentsBuilder.fromHttpUrl(getScheduleUrl()).queryParam("date", date).toUriString();
    }

    private String getScheduleUrl() {
        return url + schedule;
    }
}
