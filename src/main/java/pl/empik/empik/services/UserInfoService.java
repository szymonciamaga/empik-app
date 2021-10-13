package pl.empik.empik.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.PathVariable;
import pl.empik.empik.models.response.UserInfoResponse;

public interface UserInfoService {
    UserInfoResponse getUserInfoByLogin(@PathVariable(value = "login") final String login) throws JsonProcessingException;
}
