package com.dio.project.stay.controller;

import com.dio.project.stay.dto.request.RoomRequest;
import com.dio.project.stay.dto.response.RoomResponse;
import com.dio.project.stay.dto.security.AuthPrincipal;
import com.dio.project.stay.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RequestMapping("/Room")
@Controller
public class RoomController {

    private final RoomService roomService;

    //아이템 기본정보 입력해서 디비에 저장하고
    //아이디 반환  받아서 뷰로 전송

    @PostMapping("/new")
    public void newRoom(@AuthenticationPrincipal AuthPrincipal authPrincipal,
                        RoomRequest roomRequest
                        ){
        if(userAuthCheck(roomRequest.userId(), authPrincipal.getUsername())){
            roomService.saveRoom(roomRequest.toDto(authPrincipal.toUserAccountDto()));
        }

    }

    @GetMapping("/get?itemId={itemId}&roomId={roomId}")
    public String getRoom(Long roomId, Long itemId, ModelMap map){
        RoomResponse response = RoomResponse.from(roomService.getRoom(roomId, itemId));
        map.addAttribute("room",response);
        return "";
    }

    @PostMapping("/update")
    public String updateRoom(@AuthenticationPrincipal AuthPrincipal authPrincipal,
                             RoomRequest roomRequest){
        if(userAuthCheck(roomRequest.userId(), authPrincipal.getUsername())){
            roomService.updateRoom(roomRequest.toDto(authPrincipal.toUserAccountDto()));
        }
        return "";
    }

    @GetMapping("/delete?itemId={itemId}&roomId={roomId}")
    public String deleteRoom(@AuthenticationPrincipal AuthPrincipal authPrincipal,
                             @PathVariable Long roomId,
                             @PathVariable Long itemId){
        roomService.deleteRoom(roomId, itemId);
        return "";
    }


    private boolean userAuthCheck(String inputName, String principalName){
        return inputName.equals(principalName);
    }
}
