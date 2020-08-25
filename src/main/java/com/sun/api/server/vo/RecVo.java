package com.sun.api.server.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
public class RecVo {
    private String term;
    //recAveragePrice 로 변
    //private double recValue;
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy.MM.dd")
    private Date tradeDate;
	
	private String tradeDateString;
	
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
    //육지(0) 제주(1) 구분
    private int division;
    
    
}
