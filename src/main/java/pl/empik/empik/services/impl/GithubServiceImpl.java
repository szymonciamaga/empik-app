package pl.empik.empik.services.impl;

import org.springframework.stereotype.Service;
import pl.empik.empik.client.GithubClient;
import pl.empik.empik.models.api.GithubUserApiResponse;
import pl.empik.empik.services.GithubService;

@Service
public class GithubServiceImpl implements GithubService {

    private final GithubClient githubClient;

    public GithubServiceImpl(final GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    @Override
    public GithubUserApiResponse getUserInfoByLogin(final String login) {
        return githubClient.getUserInfoByLogin(login).getBody();
    }
}
