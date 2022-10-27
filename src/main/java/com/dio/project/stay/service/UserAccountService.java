package com.dio.project.stay.service;

import com.dio.project.stay.domain.UserAccount;
import com.dio.project.stay.dto.UserAccountDto;
import com.dio.project.stay.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class UserAccountService {
    private final UserAccountRepository userAccountRepository;

    //중복검사
    public boolean emailOverlapCheck(String email){
        //null이면 가입가능하다는 의미로 트루반환
        return userAccountRepository.findByEmail(email).isEmpty();
    }

    @Transactional
    public void saveUserAccount(UserAccountDto dto){

        userAccountRepository.save(dto.toEntity());
    }

    public UserAccountDto getUserAccount(String userId){
        return userAccountRepository.findByUserId(userId).map(UserAccountDto::from).orElseThrow();
    }

    @Transactional
    public void updateUserAccount(UserAccountDto dto){
        UserAccount userAccount = userAccountRepository.getReferenceById(dto.getUserId());
        try{
            userAccount.setUserPwd(dto.getUserPwd());
            userAccount.setNickname(dto.getNickname());
            userAccount.setPhone(dto.getPhone());
            userAccount.setUserStatus(dto.getUserStatus());
        }catch(NullPointerException e){
            log.warn("유저정보업데이트실패 - 널");
        }
    }

    public void deleteUserAccount(String userId){
        userAccountRepository.deleteByUserId(userId);
    }

    private String increaseUserId(String userId){
        return "";
    }
}
