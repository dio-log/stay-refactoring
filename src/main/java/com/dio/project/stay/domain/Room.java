package com.dio.project.stay.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne
    @Setter
    @JoinColumn(name="item_id",nullable = false)
    private Item item;

    @Setter @Column(nullable = false,length = 55) private String roomName;
    @Setter @Column(nullable = false)  private int roomPrice;
    @Setter @Column(nullable = false,length = 20)  private String bedType;
    @Setter @Column(nullable = false)  private int bedCount;
    @Setter @Column(nullable = false) private int roomSize;
    @Setter @Column(nullable = false,length = 20) private String viewType;
    @Setter @Column(nullable = false,length = 20) private String roomTheme;
    @Setter @Column(nullable = false,length = 500) private String roomOption;
    @Setter @Column(nullable = false) private int basicPeople;
    @Setter @Column(nullable = false) private int maxPeople;
    @Setter @Column(nullable = false,length = 10000) private String imgPath;
    @Setter @Column(nullable = false,columnDefinition = "varchar(4) default 't'") private String roomStatus;
    // y, n, t(temp)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false, updatable = false) private LocalDateTime createdAt;    //생성일시
    @CreatedBy
    @Column(nullable = false,length = 100,updatable = false) private String createdBy;    //생성자
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    @Column(nullable = false) private LocalDateTime modifiedAt;   //수정일시
    @LastModifiedBy
    @Column(nullable = false,length = 100) private String modifiedBy;  //수정자

    protected Room(){}

    public static Room of(Item item,
                String roomName,
                int roomPrice,
                String bedType,
                int bedCount,
                int roomSize,
                String viewType,
                String roomTheme,
                String roomOption,
                int basicPeople,
                int maxPeople,
                String imgPath,
                String roomStatus) {
      return new Room(item,
              roomName,
              roomPrice,
              bedType,
              bedCount,
              roomSize,
              viewType,
              roomTheme,
              roomOption,
              basicPeople,
              maxPeople,
              imgPath,
              roomStatus);
    }

    private Room(Item item,
                String roomName,
                int roomPrice,
                String bedType,
                int bedCount,
                int roomSize,
                String viewType,
                String roomTheme,
                String roomOption,
                int basicPeople,
                int maxPeople,
                String imgPath,
                String roomStatus) {
        this.item = item;
        this.roomName = roomName;
        this.roomPrice = roomPrice;
        this.bedType = bedType;
        this.bedCount = bedCount;
        this.roomSize = roomSize;
        this.viewType = viewType;
        this.roomTheme = roomTheme;
        this.roomOption = roomOption;
        this.basicPeople = basicPeople;
        this.maxPeople = maxPeople;
        this.imgPath = imgPath;
        this.roomStatus = roomStatus;
    }
}
