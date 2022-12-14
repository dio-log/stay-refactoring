package com.dio.project.stay.service;

import com.dio.project.stay.domain.Item;
import com.dio.project.stay.domain.type.ItemSortType;
import com.dio.project.stay.dto.ItemDto;
import com.dio.project.stay.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public Page<ItemDto> searchItems(String search_keyword, Pageable pageable){
        if(search_keyword == null || search_keyword.isBlank()){
            return itemRepository.findAll(pageable).map(ItemDto::from);
        }
        return itemRepository.findByItemAddrContaining(search_keyword,pageable).map(ItemDto::from);
    }

    //임시
    @Transactional
    public Page<ItemDto> getItems(
            String searchWord,
            String date,
            String headcount,
            ItemSortType itemSortType,
            List<String> options,
            Pageable pageable) {
        return  itemRepository.findByItemAddrContaining(searchWord,pageable).map(ItemDto::from);

    }

    @Transactional(readOnly = true)
    public ItemDto getItem(Long id){
        return itemRepository.findById(id)
                .map(ItemDto::from).orElseThrow();
    }

    @Transactional
    public void updateItem(ItemDto dto){
        Item item = itemRepository.getReferenceById(dto.id());
        try{
           item.setItemName(dto.itemName());
           item.setItemGroup(dto.itemGroup());
           item.setItemAddr(dto.itemAddr());
           item.setItemAddrDetail(dto.itemAddrDetail());
           item.setItemAddrExtra(dto.itemAddrExtra());
           item.setItemEvent(dto.itemEvent());
           item.setImgPath(dto.imgPath());
           item.setInfoAround(dto.infoAround());
           item.setInfoBasic(dto.infoBasic());
           item.setInfoNotice(dto.infoNotice());
           item.setInfoParking(dto.infoParking());
           item.setInfoPeople(dto.infoPeople());
           item.setInfoRefund(dto.infoRefund());
        }catch (NullPointerException e){
            log.warn("아이템 등록실패 - 필수사항 기재되지 않음");
        }
    }

    @Transactional
    public Long saveItem(ItemDto dto){
        return itemRepository.save(dto.toEntity()).getId();
    }

    public void deleteItem(Long id){
        itemRepository.deleteById(id);
    }

}
