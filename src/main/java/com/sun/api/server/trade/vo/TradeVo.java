package com.sun.api.server.trade.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class TradeVo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String tradeId;

    @ElementCollection(targetClass=String.class)
    private List<String> imageUrl;
    // 설치위치
    private String location;
    // 설치용량
    private Double kw;
    // 수익률
    private Double yields;
    // 매도가격
    private int price;
    // 월평균 매출
    private int averageMonthlySales;
    // 발전시간
    private Double powerGenerationTime;
    // 발전소 연차
    private int years;
    // 발전 시작월
    private String developmentStartMonth;
    // 가중치, Rec 가중치
    private Double recWeight;
    // Rec 계약형태
    private String recContractType;

    private String buildingType;

    //  연간 운영관리비
    private int operatingCost;
    // 고정지출 항목
    private String fixedExpenses;
    // 패널
    private String panel;
    // 인버터
    private String inverter;
    // 구조물 타입
    private String structureType;
    // 토지 면적
    private String landExten;
    // 남은 대출금액
    private int remainsLoanCost;
    // 대출연계
    private String loanLinkage;
    // 판매상태
    private boolean salesStatus;

}
