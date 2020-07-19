package com.sun.api.server.vo;

import lombok.Data;

@Data
public class RecVo {
    private String term;
    //recAveragePrice 로 변
    //private double recValue;
    
    //rec 평균
    private double recAveragePrice;
    //rec 최고가
    private double recHighestPrice;
    //rec 최저가
    private double recLowestPrice;
    //거래량
    private double tradingVolume;
    //매도주문
    private double sellOrderVolume;
    //매수주문
    private double purchaseOrderVolume;
    // 평균 차액
    private double priceDifference;
    //거래량 차
    private double volumeDifference;
    
    
}
