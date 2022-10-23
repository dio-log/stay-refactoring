package com.dio.project.stay.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString(callSuper = true) //부모프로퍼티까지 찍음
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne
    @JoinColumn(name = "user_account_id",nullable = false)
    private UserAccount userAccount; //userAccount가 연관관계의 주인이됨


    @Setter
    @OneToMany(mappedBy = "item") //Room엔티티에있는 item이 주인이라고 설정
    @ToString.Exclude
    private List<Room> rooms = new ArrayList<>();

    @Setter @Column(nullable = false, length = 30) private String itemName;
    @Setter @Column(nullable = false, length = 30) private String itemGroup;
    @Setter @Column(nullable = false, length = 55) private String itemAddr;
    @Setter @Column(nullable = false, length = 55) private String itemAddrDetail;
    @Setter @Column(length = 55) private String itemAddrExtra;
    @Setter @Column(length = 1000) private String itemEvent;
    @Setter @Column(nullable = false, length = 2000) private String imgPath;
    @Setter
    @Column(columnDefinition = "varchar(4) default '0'", length = 5) private String grade;
    @Setter @Column(length = 2000) private String infoAround;
    @Setter @Column(length = 2000) private String infoBasic;
    @Setter @Column(length = 2000) private String infoNotice;
    @Setter @Column(length = 2000) private String infoParking;
    @Setter @Column(length = 2000) private String infoPeople;
    @Setter @Column(nullable = false, length = 2000) private String infoRefund;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false) private LocalDateTime createdAt;
    @CreatedBy
    @Column(nullable = false,length = 100) private String createdBy;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    @Column(nullable = false) private LocalDateTime modifiedAt;
    @LastModifiedBy
    @Column(length = 100) private String modifiedBy;

    protected Item(){}

    //엔티티객체 생성 및 반환
    public static Item of(
                UserAccount userAccount,
                String itemName,
                String itemGroup,
                String itemAddr,
                String itemAddrDetail,
                String itemAddrExtra,
                String itemEvent,
                String imgPath,
                String grade,
                String infoAround,
                String infoBasic,
                String infoNotice,
                String infoParking,
                String infoPeople,
                String infoRefund,
                LocalDateTime createdAt,
                String createdBy,
                LocalDateTime modifiedAt,
                String modifiedBy) {
        return new Item(userAccount,
                itemName,
                itemGroup,
                itemAddr,
                itemAddrDetail,
                itemAddrExtra,
                itemEvent,
                imgPath,
                grade,
                infoAround,
                infoBasic,
                infoNotice,
                infoParking,
                infoPeople,
                infoRefund,
                createdAt,
                createdBy,
                modifiedAt,
                modifiedBy);
    }

    private Item(
            UserAccount userAccount,
                String itemName,
                String itemGroup,
                String itemAddr,
                String itemAddrDetail,
                String itemAddrExtra,
                String itemEvent,
                String imgPath,
                String grade,
                String infoAround,
                String infoBasic,
                String infoNotice,
                String infoParking,
                String infoPeople,
                String infoRefund,
                LocalDateTime createdAt,
                String createdBy,
                LocalDateTime modifiedAt,
                String modifiedBy) {
        this.userAccount = userAccount;
        this.itemName = itemName;
        this.itemGroup = itemGroup;
        this.itemAddr = itemAddr;
        this.itemAddrDetail = itemAddrDetail;
        this.itemAddrExtra = itemAddrExtra;
        this.itemEvent = itemEvent;
        this.imgPath = imgPath;
        this.grade = grade;
        this.infoAround = infoAround;
        this.infoBasic = infoBasic;
        this.infoNotice = infoNotice;
        this.infoParking = infoParking;
        this.infoPeople = infoPeople;
        this.infoRefund = infoRefund;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedAt = modifiedAt;
        this.modifiedBy = modifiedBy;
    }
}
