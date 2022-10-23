package com.dio.project.stay.service;

import com.dio.project.stay.domain.Room;
import com.dio.project.stay.dto.RoomDto;
import com.dio.project.stay.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Transactional(readOnly = true)
    public RoomDto getRoom(long itemId, long roomId){
        return roomRepository.findByItemItemIdAndById(itemId,roomId)
                .map(RoomDto::from)
                .orElseThrow();
    }

    public void updateRoom(RoomDto dto){
        Room room = roomRepository.getReferenceById(dto.id());
        try{
            room.setItem(dto.itemDto().toEntity());
            room.setRoomName(dto.roomName());
            room.setRoomPrice(dto.roomPrice());
            room.setBedType(dto.bedType());
            room.setBedCount(dto.bedCount());
            room.setRoomSize(dto.roomSize());
            room.setViewType(dto.viewType());
            room.setRoomTheme(dto.roomTheme());
            room.setRoomOption(dto.roomOption());
            room.setBasicPeople(dto.basicPeople());
            room.setMaxPeople(dto.maxPeople());
            room.setImgPath(dto.imgPath());
            room.setRoomStatus(dto.roomStatus());
        }catch(NullPointerException e){
            log.warn("룸업데이트 실패");
        }
    }

    public void saveRoom(RoomDto dto){
        roomRepository.save(dto.toEntity());
    }

    public void deleteRoom(long roomId){
        roomRepository.deleteById(roomId);
    }


}
