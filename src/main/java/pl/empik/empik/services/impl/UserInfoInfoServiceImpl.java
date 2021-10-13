package pl.empik.empik.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import pl.empik.empik.mapper.UserInfoMapper;
import pl.empik.empik.models.api.GithubUserApiResponse;
import pl.empik.empik.models.response.UserInfoResponse;
import pl.empik.empik.services.CalculationService;
import pl.empik.empik.services.GithubService;
import pl.empik.empik.services.RequestCountService;
import pl.empik.empik.services.UserInfoService;

@Service
public class UserInfoInfoServiceImpl implements UserInfoService {

    private final GithubService githubService;
    private final RequestCountService requestCountService;
    private final CalculationService calculationService;
    private final UserInfoMapper userInfoMapper;

    public UserInfoInfoServiceImpl(final GithubService githubService,
                                   final RequestCountService requestCountService,
                                   final CalculationService calculationService,
                                   final UserInfoMapper userInfoMapper) {
        this.githubService = githubService;
        this.requestCountService = requestCountService;
        this.calculationService = calculationService;
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public UserInfoResponse getUserInfoByLogin(final String login) throws JsonProcessingException {
        final GithubUserApiResponse githubUserApiResponse = githubService.getUserInfoByLogin(login);
        requestCountService.updateLoginCount(login);
        final UserInfoResponse userInfoResponse =
                userInfoMapper.mapGithubResponseToUserInfoResponse(githubUserApiResponse);
        userInfoResponse.setCalculations(calculationService.calculate(githubUserApiResponse));
        return userInfoResponse;
    }
}
