package pl.empik.empik.services;


import pl.empik.empik.models.api.GithubUserApiResponse;

import java.math.BigDecimal;

public interface CalculationService {
    BigDecimal calculate(final GithubUserApiResponse githubUserApiResponse);
}
