package com.dio.project.stay.service;

import com.dio.project.stay.domain.Item;
import com.dio.project.stay.domain.Room;
import com.dio.project.stay.dto.RoomDto;
import com.dio.project.stay.repository.ItemRepository;
import com.dio.project.stay.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public RoomDto getRoom(Long itemId, Long roomId){
        return RoomDto.from(roomRepository.findByIdAndItem_Id(itemId,roomId));
    }

    public List<RoomDto> getRooms(Long itemId){
        return roomRepository.findByItem_Id(itemId)
                .stream().map(RoomDto::from)
                .collect(Collectors.toList());
    }

    public void updateRoom(RoomDto dto){
        Room room = roomRepository.getReferenceById(dto.id());

        try{
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

    public void deleteRoom(long roomId, Long itemId){
        roomRepository.deleteById(roomId);
    }


    public void saveRoom(RoomDto roomDto) {
        Item item = itemRepository.getReferenceById(roomDto.itemId());
        roomRepository.save(roomDto.toEntity(item));
    }
}
