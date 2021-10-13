package pl.empik.empik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.empik.empik.models.entity.RequestCounter;

import java.util.Optional;

public interface RequestCounterRepository extends JpaRepository<RequestCounter, Long> {
    Optional<RequestCounter> findByLogin(final String login);
}
