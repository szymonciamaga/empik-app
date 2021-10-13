package pl.empik.empik.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import pl.empik.empik.models.api.GithubUserApiResponse;

public interface GithubService {
    GithubUserApiResponse getUserInfoByLogin(final String login) throws JsonProcessingException;
}
