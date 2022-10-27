package com.dio.project.stay.domain;

import com.dio.project.stay.domain.type.UserStatus;
import com.dio.project.stay.domain.type.UserType;
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
public class UserAccount extends AuditingFields{
    @Id
    @Column(length = 50)
    private String userId;

    //이메일로 가입된 회원인지 조회
    @Setter @Column(length = 30) private String userPwd;
    @Setter @Column(nullable = false,length = 50) private String email;
    @Setter @Column(nullable = false,length = 10) private String nickname;
    @Setter @Column(nullable = false,length = 20) private String phone;

    @Setter @Column(nullable = false,length = 10) private UserType userType;

    @Setter @Column(nullable = false,length = 10) private UserStatus userStatus;



    protected UserAccount() {}

    public static UserAccount of(String userId, String userPwd, String email, String nickname, String phone, UserType userType, UserStatus userStatus) {
        return new UserAccount(userId,userPwd,email,nickname,phone,userType,userStatus);
    }

    public UserAccount(String userId, String userPwd, String email, String nickname, String phone, UserType userType, UserStatus userStatus) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
        this.userType = userType;
        this.userStatus = userStatus;
    }
}

