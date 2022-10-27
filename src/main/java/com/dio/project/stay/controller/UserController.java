package com.dio.project.stay.controller;

import com.dio.project.stay.dto.UserAccountDto;
import com.dio.project.stay.dto.request.UserAccountRequest;
import com.dio.project.stay.dto.response.UserAccountResponse;
import com.dio.project.stay.dto.security.AuthPrincipal;
import com.dio.project.stay.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController //빈등록, 컴포넌트랑 비슷함, 그냥 타입?이름?을 달아준것(분류)
//알아서 변환해서 값을 받고 보내고 , 보통은 json
public class UserController {
    //이메일 중복검사 및 휴면계정 검사
    //가입완료 - 디비 저장
    //개인정보 불러오기
    //수정
    //회원삭제 - status변경

    private final UserAccountService userAccountService;


    @PostMapping("/new")  //계정 생성
    public String newUserAccount(UserAccountRequest request) {
        userAccountService.saveUserAccount(request.toDto());
        return "register.ok";
    }
    @GetMapping("/get") //계정 불러오기
    public String userAccount(
            @AuthenticationPrincipal AuthPrincipal authPrincipal,
            ModelMap map
    ){
        UserAccountResponse response = UserAccountResponse.from(userAccountService.getUserAccount(authPrincipal.getUsername()));
        map.addAttribute("userAccount", response);
        return "";
    }

    @PostMapping("/update")
    public String updateUserAccount(
            @AuthenticationPrincipal AuthPrincipal authPrincipal,
            UserAccountRequest request
    ){
        userAccountService.updateUserAccount(request.toDto());
        return "";
    }

    @GetMapping("/delete")
    public String deleteUserAccount(@AuthenticationPrincipal AuthPrincipal authPrincipal){
        userAccountService.deleteUserAccount(authPrincipal.getUsername());
        return "";
    }
}
