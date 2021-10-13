package pl.empik.empik.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "request_counter", schema = "empik")
public class RequestCounter extends AbstractEntity {

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "request_count", nullable = false)
    private Long requestCount;

    public RequestCounter() {}

    public RequestCounter(final String login, final Long requestCount) {
        this.login = login;
        this.requestCount = requestCount;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(Long requestCount) {
        this.requestCount = requestCount;
    }
}
