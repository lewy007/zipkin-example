package pl.lewandowski.client1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

    private final RestTemplate restTemplate;

    public ClientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String get() {

//        RestClient restClient = new Res
//        RestTemplate restTemplate = new RestTemplate();
        // Zamiast powyżej defaultowego rest template, któy jest pusty, nie posiada trackowania z builderagit branch
        //uzywamy stworzonego przez nas zgodnie z klasą config, ktora ma info o trackowaniu
        String forObject = restTemplate.getForObject("http://localhost:8082", String.class);
        System.err.println(forObject);

        return forObject;
    }
}
