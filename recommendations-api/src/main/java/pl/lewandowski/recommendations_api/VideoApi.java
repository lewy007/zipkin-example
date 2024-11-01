package pl.lewandowski.recommendations_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class VideoApi {

    @GetMapping
    public String get(@RequestHeader Map<String, String> headers) {
        return "Hello from Recommendation Api!";
    }
}

// RequestHeader zwraca nam cztery naglowki plus jeden z mikroserwisu nr 1 - Client - traceparent,
// ktore mozemy sledzic(trackowac) za pomoca klasy Config i stworzonego przez nas Rest Template.