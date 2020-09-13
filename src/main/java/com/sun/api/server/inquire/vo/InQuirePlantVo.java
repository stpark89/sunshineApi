package com.sun.api.server.inquire.vo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 자관리 - 발전소 매각
 */
@Data
@Entity
public class InQuirePlantVo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    // 주소
    private String location;
    // 사업주명
    private String name;
    //연락처
    private String phone;
    //발전시작일
    private String developmentStartMonth;
    //모니터링
    private boolean monitering;
    //매각 형태
    private boolean saleForm;
    //사업용량
    private double kw;
    //전력계약형태
    private String powerContractType;
    // 모듈
    private String module;
    //모듈용량
    private double moduleKW;
    //인버터
    private String inverter;
    //인버터용량
    private double inverterKW;
    //희망금액
    private double price;
    //대출금액
    private double loan;
    //문의 내용
    private String content;

}
