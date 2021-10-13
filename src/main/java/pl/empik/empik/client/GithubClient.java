package pl.empik.empik.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.empik.empik.handlers.RestTemplateResponseErrorHandler;
import pl.empik.empik.models.api.GithubUserApiResponse;

import java.util.List;

@Component
public class GithubClient {

    private final RestTemplate restTemplate;

    @Autowired
    public GithubClient(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }


    @Value("${github.api.url}")
    private String githubApiUrl;

    public ResponseEntity<GithubUserApiResponse> getUserInfoByLogin(final String login) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        final HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(githubApiUrl + "/users/" + login,
                HttpMethod.GET, entity,
                GithubUserApiResponse.class
        );
    }
}
