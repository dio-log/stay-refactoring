package com.dio.project.stay.controller;

import com.dio.project.stay.domain.type.ItemSortType;
import com.dio.project.stay.dto.ItemDto;
import com.dio.project.stay.dto.UserAccountDto;
import com.dio.project.stay.dto.request.ItemRequest;
import com.dio.project.stay.dto.response.ItemResponse;
import com.dio.project.stay.dto.security.AuthPrincipal;
import com.dio.project.stay.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/Item")
@Controller
public class ItemController {

    private final ItemService itemService;

    //아이템 생성
    @PostMapping("/new")
    public String newItem(
            @AuthenticationPrincipal AuthPrincipal authPrincipal,
            ItemRequest request
            ){
        itemService.saveItem(request.toDto(authPrincipal.toUserAccountDto()));
        return "";
    }

    //단일 아이템 with roomlist
    @GetMapping("/get/{id}")
    public String getItem(@PathVariable Long id, ModelMap map){
        ItemResponse item = ItemResponse.from(itemService.getItem(id));
        map.addAttribute("item", item);
        return "";
    }

    //아이템리스트
    @GetMapping("/get/list")
    public String getItems(
            @RequestParam String searchWord,
            @RequestParam String date,
            @RequestParam String headcount,
            @RequestParam ItemSortType itemSortType,
            @RequestParam List<String> options,
            @PageableDefault(size = 5,sort = "grade",direction = Sort.Direction.DESC) Pageable pageable,
            ModelMap map
    ){
        Page<ItemDto> items =  itemService.getItems(searchWord, date, headcount, itemSortType, options, pageable);
        Page<ItemResponse> itemsResponse = items.map(ItemResponse::from)   ;
        map.addAttribute("items",itemsResponse);

        return "";
    }

    @PostMapping("/update")
    public String updateItem(
                             ItemRequest itemRequest,
                             @AuthenticationPrincipal AuthPrincipal authPrincipal){

        if(userAuthCheck(itemRequest.getUserId(),authPrincipal.getUsername())){
            itemService.updateItem(itemRequest.toDto(authPrincipal.toUserAccountDto()));
        }else{
            throw new RuntimeException();
        }

        return "";
    }

    @GetMapping("/delete?userId={userId}&itemId={itemId}")
    public String deleteItem(@AuthenticationPrincipal AuthPrincipal authPrincipal,
                             String userId,
                             Long itemId
                             ){
        if(userAuthCheck(userId, authPrincipal.getUsername())){
            itemService.deleteItem(itemId);
        }
        return "";
    }

    private boolean userAuthCheck(String inputName, String principalName){
        return inputName.equals(principalName);
    }

}
