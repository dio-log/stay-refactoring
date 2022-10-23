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
    //이메일로 중복검사 후 세이브해야함,
    public boolean emailOverlapCheck(String email){
        //null이면 가입가능하다는 의미로 트루반환
        return userAccountRepository.findByEmail(email).isEmpty();
    }

    public void saveUserAccount(UserAccountDto dto){
        userAccountRepository.save(dto.toEntity());
    }
    public UserAccountDto getUserAccount(long userAccountId){
        return userAccountRepository.findById(userAccountId).map(UserAccountDto::from).orElseThrow();
    }

    public void updateUserAccount(UserAccountDto dto){
        UserAccount userAccount = userAccountRepository.getReferenceById(dto.id());
        try{
            userAccount.setUserPwd(dto.userPwd());
            userAccount.setEmail(dto.email());
            userAccount.setPhone(dto.phone());
            userAccount.setNickname(dto.nickname());
        }catch(NullPointerException e){
            log.warn("유저정보업데이트실패 - 널");
        }
    }

    public void deleteUserAccount(long userAccountId){
        userAccountRepository.deleteById(userAccountId);
    }




}
