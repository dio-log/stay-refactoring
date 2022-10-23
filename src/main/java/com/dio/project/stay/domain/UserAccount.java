package com.dio.project.stay.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //카카오, 구글 api사용시 id가 null일 수 있음
    //이메일로 가입된 회원인지 조회
    @Setter @Column(length = 55) private String userId;
    @Setter @Column(length = 30) private String userPwd;
    @Setter @Column(nullable = false,length = 50) private String email;
    @Setter @Column(nullable = false,length = 10) private String nickname;
    @Setter @Column(nullable = false,length = 20) private String phone;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate @Column(nullable = false) private LocalDateTime createdAt;
    @CreatedBy @Column(nullable = false,length = 100) private String createdBy;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate @Column(nullable = false) private LocalDateTime modifiedAt;
    @LastModifiedBy @Column(length = 100) private String modifiedBy;

    protected UserAccount() {}

    public static UserAccount of(String userId, String userPwd, String email, String nickname, String phone) {
        return new UserAccount(userId,userPwd,email,nickname,phone);
    }

    private UserAccount(String userId, String userPwd, String email, String nickname, String phone) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
    }
}
