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
    private int studentNumber; // Primary key, 가입 순서

    private String codeNumber; // 학생증 바코드
    private String studentName;
    private String email; // @bssm.hs.kr
    private String password;
    private String point;
    private short isAdmin; // 관리자인가?
    private short isCoop; // 매점부원인가?
    private String refToken; // token
    private String pin; // self counter password

    @Builder
    public User(
            int studentNumber, String codeNumber,
            String studentName, String email, String password,
            String point, short isAdmin, short isCoop,
            String refToken, String pin
    ) {
        this.studentNumber = studentNumber;
        this.codeNumber = codeNumber;
        this.studentName = studentName;
        this.email = email;
        this.password = password;
        this.point = point;
        this.isAdmin = isAdmin;
        this.isCoop = isCoop;
        this.refToken = refToken;
        this.pin = pin;
    }
}