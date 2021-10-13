package pl.empik.empik.mapper;

import org.springframework.stereotype.Component;
import pl.empik.empik.models.api.GithubUserApiResponse;
import pl.empik.empik.models.response.UserInfoResponse;

@Component
public class UserInfoMapper {
    public UserInfoResponse mapGithubResponseToUserInfoResponse(final GithubUserApiResponse githubUserApiResponse) {
        final UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setId(githubUserApiResponse.getId());
        userInfoResponse.setAvatarUrl(githubUserApiResponse.getAvatarUrl());
        userInfoResponse.setCreatedAt(githubUserApiResponse.getCreatedAt());
        userInfoResponse.setName(githubUserApiResponse.getName());
        userInfoResponse.setType(githubUserApiResponse.getType());
        userInfoResponse.setLogin(githubUserApiResponse.getLogin());
        return userInfoResponse;
    }
}
