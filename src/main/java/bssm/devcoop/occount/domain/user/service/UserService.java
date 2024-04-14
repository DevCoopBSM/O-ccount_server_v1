package bssm.devcoop.occount.domain.user.service;

import bssm.devcoop.occount.domain.user.User;
import bssm.devcoop.occount.domain.user.presentation.dto.LoginRequestDto;
import bssm.devcoop.occount.domain.user.presentation.dto.LoginResponseDto;
import bssm.devcoop.occount.domain.user.repository.UserRepository;
import bssm.devcoop.occount.domain.user.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Value("${jwt:secret}")
    private String secretKey;

    private final Long exprTime = 1000 * 60 * 60L;

    public LoginResponseDto login(LoginRequestDto dto) throws Exception {
        String email = dto.email();
        String password = dto.password();

        User u = userRepository.findByEmail(email);

        if(u == null) {
            throw new Exception("이메일이 올바르지 않습니다.");
        } else if(!(u.getPassword()).equals(password)) {
            throw new Exception("비밀번호가 올바르지 않습니다.");
        } // Global Exception을 빠르게 정의할 필요가 있다.

        String token = JwtUtil.createJwt(u.getCodeNumber(), secretKey, exprTime);

        LoginResponseDto response = LoginResponseDto.builder()
                .token(token)
                .studentName(u.getStudentName())
                .point(u.getPoint())
                .email(email)
                .build();

        return response; // token을 cookie로?
    }
}
