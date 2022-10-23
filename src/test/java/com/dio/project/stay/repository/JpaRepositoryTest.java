package com.dio.project.stay.repository;

import com.dio.project.stay.config.JpaConfig;
import com.dio.project.stay.domain.Item;
import com.dio.project.stay.domain.UserAccount;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import static org.assertj.core.api.Assertions.assertThat;

@Disabled
@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
public class JpaRepositoryTest {
    private final UserAccountRepository userAccountRepository;
    private final ItemRepository itemRepository;


    public JpaRepositoryTest(@Autowired UserAccountRepository userAccountRepository,@Autowired ItemRepository itemRepository) {
        this.userAccountRepository = userAccountRepository;
        this.itemRepository = itemRepository;
    }

}
