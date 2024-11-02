package pl.lewandowski.video_ranking_api;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    // Dzięki temu Spring Boot dodatkowo do naszego rest template dokłada konfiguracje
    // do trackowania naszego elementu, czyli bedzie dodawana informacja sledzaca
    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }
}
