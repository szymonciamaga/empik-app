package pl.empik.empik.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Component
public class RestTemplateResponseErrorHandler
        implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse httpResponse)
            throws IOException {

        return (
                httpResponse.getStatusCode().series() == CLIENT_ERROR
                        || httpResponse.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse) throws IOException {
        switch (httpResponse.getStatusCode()
                .series()) {
            case SERVER_ERROR:
                throw new IllegalArgumentException();
            case CLIENT_ERROR:
                if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
                    throw new EntityNotFoundException("User with given login does not exist!");
                }
                break;
        }
    }
}
