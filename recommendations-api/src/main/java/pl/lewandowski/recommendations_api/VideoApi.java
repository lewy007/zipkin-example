package pl.lewandowski.recommendations_api;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class VideoApi {

    private final RestTemplate restTemplate;

    public VideoApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // RequestHeader zwraca nam cztery naglowki plus jeden z mikroserwisu nr 1 - Client - traceparent,
    // ktore mozemy sledzic(trackowac) za pomoca klasy Config i stworzonego przez nas Rest Template.

    @GetMapping
    public List<Movie> get(@RequestHeader Map<String, String> headers) {

//        List<Movie> movies = restTemplate.getForObject("http://localhost:8083", List.class);


        ResponseEntity<List<Movie>> movies = restTemplate.exchange(
                "http://localhost:8083",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Movie>>() {
                }
        );

        HttpEntity<List<Movie>> listHttpEntity = new HttpEntity<>(Objects.requireNonNull(movies.getBody()));
        ResponseEntity<List<Movie>> exchange = restTemplate.exchange(
                "http://localhost:8084",
                HttpMethod.POST,
                listHttpEntity,
                new ParameterizedTypeReference<List<Movie>>() {
                }
        );
        return exchange.getBody();
    }


}

