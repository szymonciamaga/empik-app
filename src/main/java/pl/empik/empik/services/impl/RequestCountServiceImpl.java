package pl.empik.empik.services.impl;

import org.springframework.stereotype.Service;
import pl.empik.empik.models.entity.RequestCounter;
import pl.empik.empik.repository.RequestCounterRepository;
import pl.empik.empik.services.RequestCountService;

@Service
public class RequestCountServiceImpl implements RequestCountService {

    private final RequestCounterRepository requestCounterRepository;

    public RequestCountServiceImpl(final RequestCounterRepository requestCounterRepository) {
        this.requestCounterRepository = requestCounterRepository;
    }

    @Override
    public RequestCounter updateLoginCount(final String login) {
        final RequestCounter requestCounter = requestCounterRepository.findByLogin(login)
                .orElseGet(() -> createNewRequestByLogin(login));
        requestCounter.setRequestCount(requestCounter.getRequestCount() + 1);
        return requestCounterRepository.save(requestCounter);
    }

    @Override
    public RequestCounter createNewRequestByLogin(final String login) {
        return requestCounterRepository.save(new RequestCounter(login, 0L));
    }
}
