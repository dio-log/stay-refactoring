package com.dio.project.stay.repository;

import com.dio.project.stay.domain.Room;
import com.jayway.jsonpath.JsonPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("select r from Room r where r.id = :id and r.item.id = :id1")
    Optional<Room> findByItemItemIdAndById(@Param("id") Long id, @Param("id1") Long id1);




}