package com.dio.project.stay.service;

import com.dio.project.stay.dto.ItemDto;
import com.dio.project.stay.repository.ItemRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.*;

@Disabled
@DisplayName("비즈니스 로직 - 아이템")
@ExtendWith(MockitoExtension.class)
class ItemServiceTest {
    @InjectMocks private  ItemService sut;

    @Mock private ItemRepository itemRepository;

    @DisplayName("검색시 주소가 일치하는 아이템 반환")
    @Test
    void givenSearchParam_whenSearchItems_thenReturnItemList(){

                // Given
        String param = "강남";
        Page<ItemDto> items = sut.searchItems(param, Pageable.unpaged());
                // When

                // Then
        assertThat(items).isNull();
    }
}