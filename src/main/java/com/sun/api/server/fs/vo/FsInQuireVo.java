package com.sun.api.server.fs.vo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class FsInQuireVo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // 문의하기 종류
    private String inquireType;

    // 사용자 이름
    private String userName;
    // 전화번호
    private String userPhone;
    // 이메일
    private String userEmail;
    // 문의 내용
    private String inquireText;
    // 주소
    private String jibun;
    // 발전용량 : 사업부지 적정용량', 희망용량 (값)
    private String generationCapacity;
    // 전력판매유형 : FIT 장기계약', 현물거래
    private String electricitySalesType;
    // installationplace
    private String installationplace;
    // 전체 설치 용량
    private Double requestTotalKw;
}
