package bssm.devcoop.occount.domain.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    private String userCode; // Primary key, 사용자 (학생증) 바코드

    private int userId; // 사용자 ID
    private String userName;
    private String email; // @bssm.hs.kr
    private String password;
    private String point;
    private short userType; // 사용자 유형, 0 ~ 3
    private String accToken; // token
    private String pin; // 셀프계산대 비밀번호

    @Builder
    public User(
            String userCode, int userId,
            String userName, String email, String password,
            String point, short userType,
            String accToken, String pin
    ) {
        this.userCode = userCode;
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.point = point;
        this.userType = userType;
        this.accToken = accToken;
        this.pin = pin;
    }
}