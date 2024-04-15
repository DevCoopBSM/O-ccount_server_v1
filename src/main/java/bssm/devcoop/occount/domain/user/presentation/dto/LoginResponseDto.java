package bssm.devcoop.occount.domain.user.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
// @NoArgsConstructor
@Builder
public class LoginResponseDto {
    private String token;
    private String studentName;
    private String point;
    private String email;
}
