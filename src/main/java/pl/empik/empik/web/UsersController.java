package pl.empik.empik.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.empik.empik.models.response.UserInfoResponse;
import pl.empik.empik.services.UserInfoService;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UserInfoService userInfoService;

    public UsersController(final UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("/{login}")
    @ResponseStatus(HttpStatus.OK)
    public UserInfoResponse getUserInfoByLogin(@PathVariable(value = "login") final String login) throws JsonProcessingException {
        return userInfoService.getUserInfoByLogin(login);
    }
}
