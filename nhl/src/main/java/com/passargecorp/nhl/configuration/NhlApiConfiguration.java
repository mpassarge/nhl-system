package com.passargecorp.nhl.configuration;

import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "api")
@PropertySource("classpath:nhl/webservice.properties")
@NoArgsConstructor
public class NhlApiConfiguration {

    private String url;
    private String schedule;

    public void setUrl(final String url) {
        this.url = url;
    }

    public void setSchedule(final String schedule) {
        this.schedule = schedule;
    }

    public String getScheduleUrl() {
        return url + schedule;
    }
}
