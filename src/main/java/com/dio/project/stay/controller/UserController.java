package com.dio.project.stay.controller;

import com.dio.project.stay.dto.UserAccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/register")
@RestController //빈등록, 컴포넌트랑 비슷함, 그냥 타입?이름?을 달아준것(분류)
//알아서 변환해서 값을 받고 보내고 , 보통은 json
public class UserController {
    //이메일 중복검사 및 휴면계정 검사
    //가입완료 - 디비 저장
    //개인정보 불러오기
    //수정
    //회원삭제 - status변경

    private final UserAccountDto userAccountDto;


    public String createUserAccount(ModelMap modelMap) {

        return "register.ok";
    }
}
