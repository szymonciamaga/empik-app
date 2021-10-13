package pl.empik.empik.services.impl;

import org.springframework.stereotype.Service;
import pl.empik.empik.models.api.GithubUserApiResponse;
import pl.empik.empik.services.CalculationService;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculationServiceImpl implements CalculationService {

    @Override
    public BigDecimal calculate(final GithubUserApiResponse githubUserApiResponse) {
        final BigDecimal followers = BigDecimal.valueOf(githubUserApiResponse.getFollowers());
        final BigDecimal publicRepos = BigDecimal.valueOf(githubUserApiResponse.getPublicRepos());
        return BigDecimal.valueOf(6)
                .divide(followers, 10, RoundingMode.FLOOR)
                .multiply(BigDecimal.valueOf(2)
                        .add(publicRepos));
    }
}
