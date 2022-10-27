package com.dio.project.stay.domain;

import com.dio.project.stay.domain.type.RoomStatus;
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
import javax.websocket.server.ServerEndpoint;
import java.time.LocalDateTime;


@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Room extends AuditingFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne(optional = false)
    @Setter
    @JoinColumn(name="item_id",nullable = true)
    private Item item;

    @ManyToOne(optional = false)
    @Setter
    @JoinColumn(name = "user_id",nullable = false)
    private UserAccount userAccount;

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
    @Setter @Column(nullable = false) private RoomStatus roomStatus;
    // y, n, t(temp)

    protected Room(){}

    public static Room of(Item item,
                UserAccount userAccount,
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
                RoomStatus roomStatus) {
      return new Room(item,
              userAccount,
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
                UserAccount userAccount,
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
                 RoomStatus roomStatus) {
        this.item = item;
        this.userAccount = userAccount;
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
