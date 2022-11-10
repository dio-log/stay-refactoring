package com.dio.project.stay.controller;

import com.dio.project.stay.service.RoomService;
import com.dio.project.stay.service.UserAccountService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

@WebMvcTest(RoomController.class)
class RoomControllerTest {

    protected MediaType mediaType =
            new MediaType(MediaType.APPLICATION_JSON.getType(),
                    MediaType.APPLICATION_JSON.getSubtype(),
                    StandardCharsets.UTF_8
                    );
    private final MockMvc mvc;

    @MockBean private RoomService roomService;
    @MockBean private UserAccountService userAccountService;


    RoomControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[get] 룸 리스트")
    @Test
    public void given_when_then(){
        // Given

        // When

        // Then
    }


    @DisplayName("[get] 룸 단일 페이지")


}