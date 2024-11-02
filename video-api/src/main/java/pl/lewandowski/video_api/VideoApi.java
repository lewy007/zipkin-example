package pl.lewandowski.video_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class VideoApi {

    @GetMapping
    public List<Movie> getMovies() {
        return Arrays.asList(
                new Movie(1, "The Shawshank Redemption", "Drama"),
                new Movie(2, "The Godfather", "Crime"),
                new Movie(3, "Pulp Fiction", "Crime"),
                new Movie(4, "Forest Gump", "Drama"),
                new Movie(5, "The Dark Knight", "Action")
        );
    }
}
