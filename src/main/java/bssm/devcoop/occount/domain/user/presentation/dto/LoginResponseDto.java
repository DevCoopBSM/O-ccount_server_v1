package bssm.devcoop.occount.domain.user.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
// @AllArgsConstructor
@NoArgsConstructor
public final class LoginResponseDto {
    private String token;
    private String studentName;
    private String point;
    private String email;

    // Builder로 변경할 필요?
    public LoginResponseDto(String t, String n, String p, String e) {
        this.token = t;
        this.studentName = n;
        this.point = p;
        this.email = e;
    }
}
