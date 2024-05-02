package bssm.devcoop.occount.domain.user.service;

import bssm.devcoop.occount.domain.user.User;
import bssm.devcoop.occount.domain.user.presentation.dto.LoginRequestDto;
import bssm.devcoop.occount.domain.user.presentation.dto.LoginResponseDto;
import bssm.devcoop.occount.domain.user.repository.UserRepository;
import bssm.devcoop.occount.domain.user.utils.JwtUtil;
import bssm.devcoop.occount.global.exception.GlobalException;
import bssm.devcoop.occount.global.exception.enums.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${jwt.secret}")
    private String secretKey;
    private final Long accessExprTime = 1000 * 60 * 60L;

    @Transactional
    public LoginResponseDto login(LoginRequestDto dto) throws GlobalException {
        String email = dto.getEmail();
        String password = dto.getPassword();

        User u = userRepository.findByEmail(email);

        if(u == null) {
            throw new GlobalException(ErrorCode.USER_NOT_FOUND);
        } else if(!bCryptPasswordEncoder.matches(u.getPassword(), password)) {
            throw new GlobalException(ErrorCode.PASSWORD_NOT_CORRECT);
        }

        String accessToken = JwtUtil.createJwt(u.getUserCode(), secretKey, accessExprTime);

        LoginResponseDto response = LoginResponseDto.builder()
                .accessToken(accessToken)
                .studentName(u.getUserName())
                .point(u.getPoint())
                .email(email)
                .build();

        return response;
    }

    @Transactional
    public void logout() throws GlobalException {

    }

    @Transactional
    public void pwChange() throws GlobalException {

    }
}
