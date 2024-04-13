package bssm.devcoop.occount.domain.user.service;

import bssm.devcoop.occount.domain.user.User;
import bssm.devcoop.occount.domain.user.presentation.dto.LoginRequestDto;
import bssm.devcoop.occount.domain.user.presentation.dto.LoginResponseDto;
import bssm.devcoop.occount.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public LoginResponseDto login(LoginRequestDto dto) throws Exception {
        String email = dto.email();
        String password = dto.password();

        User u = userRepository.findByEmail(email);

        if(u == null) {
            throw new Exception("이메일이 올바르지 않습니다.");
        } else if(!(u.getPassword()).equals(password)) {
            throw new Exception("비밀번호가 올바르지 않습니다.");
        } // Global Exception을 빠르게 정의할 필요가 있다.

        String token; // token 생성 및 갱신

        LoginResponseDto response = new LoginResponseDto(
                "Login Success", u.getPoint(),
                email, password);

        return response; // token도 보내주어야 하는 건지?
    }
}
