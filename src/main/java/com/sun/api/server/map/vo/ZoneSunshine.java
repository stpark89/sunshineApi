package com.sun.api.server.map.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ZoneSunshine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
    
    private String createdUser;

    private String updatedUser;
    //시군구
    private String sggNm;
    //시
    private String siNm;
    

    //1월 
    private double january;
    //2월 
    private double february;
    //3월
    private double march;
    //4월
    private double april;
    //5월 
    private double may;
    //6월 
    private double june;
    //7월 
    private double july;
    //8월 
    private double august;
    //9월 
    private double september;
    //10월 
    private double october;
    //11월 
    private double novembe;
    //12월 
    private double december;
    //년 평
    private double annualAverage;
    
    public ZoneSunshine() {
    	
    }
    
    public ZoneSunshine(String siNm, String sggNm, double january, double february, double march, double april, double may, double june, double july, double august, double september, double october, double novembe, double december, double annualAverage){
    	this.sggNm = sggNm;
    	this.siNm = siNm;
    	this.january = january;
    	this.february = february;
    	this.march = march;
    	this.april = april;
    	this.may = may;
    	this.june = june;
    	this.july = july;
    	this.august = august;
    	this.september = september;
    	this.october = october;
    	this.novembe = novembe;
    	this.december = december;
    	this.annualAverage = annualAverage;
    };
    
}
