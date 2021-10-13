package pl.empik.empik.services;

import pl.empik.empik.models.entity.RequestCounter;

public interface RequestCountService {
    RequestCounter updateLoginCount(final String login);
    RequestCounter createNewRequestByLogin(final String login);
}
