package pl.lewandowski.video_ranking_api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@RestController
public class RankingApi {

    private final RestTemplate restTemplate;

    public RankingApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public List<Movie> ranking(@RequestBody List<Movie> movieList) {

        //Mikroserwis sluzy do dodania oceny
        //Pobieramy liste filmow i dla kazdego filmu dodajemy ranknig z randomowo generowana ocena z api random
        for (Movie movie : movieList) {
            String ranking = Objects.requireNonNull(restTemplate.getForObject(
                            "https://www.randomnumberapi.com/api/v1.0/random?min=1&max=10&count=1", List.class))
                    .get(0).toString();
            movie.setRanking(ranking);
        }
        return movieList;
    }
}
