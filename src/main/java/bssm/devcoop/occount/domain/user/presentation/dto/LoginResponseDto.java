package bssm.devcoop.occount.domain.user.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
// @AllArgsConstructor
@NoArgsConstructor
public final class LoginResponseDto {
    private String message;
    private String studentName;
    private String point;
    private String email;

    public LoginResponseDto(String m, String n, String p, String e) {
        this.message = m;
        this.studentName = n;
        this.point = p;
        this.email = e;
    }
}
