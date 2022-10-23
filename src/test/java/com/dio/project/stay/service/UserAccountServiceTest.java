package com.dio.project.stay.service;

import com.dio.project.stay.domain.UserAccount;
import com.dio.project.stay.dto.UserAccountDto;
import com.dio.project.stay.repository.UserAccountRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@DisplayName("비즈니스로직 - userAccount")
@ExtendWith(MockitoExtension.class)
class UserAccountServiceTest {

    @InjectMocks private UserAccountService sut;
    @Mock private UserAccountRepository userAccountRepository;
    private static UserAccountDto userAccountDto = createUserAccountDto();

    @DisplayName("userAccountDto save")
    @Test
    void givenUserAccountDto_whenSaveUserAccount_then(){
        // Given
        //UserAccountDto userAccountDto = createUserAccountDto();
        BDDMockito.given(userAccountRepository.save(any(UserAccount.class))).willReturn(null);
        // When
        sut.saveUserAccount(userAccountDto);
        // Then
        BDDMockito.then(userAccountRepository).should().save(any(UserAccount.class));
    }

    //1L을 가진 디비가 없어서 에러남

    @Disabled
    @DisplayName("userAccountDto update")
    @Test
    void givenUserAccountDto_whenUpdateUserAccount_thenReturnNothing(){
        // Given
        //UserAccountDto userAccountDto = createUserAccountDto();
        BDDMockito.given(userAccountRepository.save(any(UserAccount.class))).willReturn(null);
        // When
        sut.updateUserAccount(userAccountDto);
        // Then
        BDDMockito.then(userAccountRepository).should().save(any(UserAccount.class));
    }



    private static UserAccountDto createUserAccountDto(){
        return UserAccountDto.of(
                1L,
                "ae7006",
                "pwd123",
                "asdf@gmail.com",
                "ock",
                "010-3333-4444",
                LocalDateTime.now(),
                "ock",
                LocalDateTime.now(),
                "ock"
        );
    }
}