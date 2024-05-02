package bssm.devcoop.occount.domain.user.presentation;

import bssm.devcoop.occount.domain.user.presentation.dto.LoginRequestDto;
import bssm.devcoop.occount.domain.user.presentation.dto.LoginResponseDto;
import bssm.devcoop.occount.domain.user.service.AuthService;
import bssm.devcoop.occount.global.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService userService;
    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto dto) throws GlobalException{
        return userService.login(dto);
    }

    @PostMapping("/logout")
    public void logout() throws GlobalException {
        userService.logout();
        log.info("Logout Success");
    }

    @PostMapping("/pwChange")
    public void pwChange() throws GlobalException {
        userService.pwChange();
        log.info("Success");
    }

}
