package com.sun.api.server.module.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class InverterInfoVo {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    

    //제조사
    private String manufacturer;
    
    //품명
    private String productName;
   
    //출력용량
    private double outputCapacity;
    
    //인증
    private String certified;
    
    //최대 입력 전압 
    private int maximumInputVoltage;
    
    //입력 전압 변동 범위 
    private String inputVoltageRangeVariation;
    
    //입력 String
    private String inputString;
    
    //무게
    private double weight;
    
    //최대 효율
    private double maximumEfficiency;
    
    //외형 크기 
    private String externalSize;
    
    //무상 보증 
    private String freeGuarantee;
    
    //매입 단가
    private int purchasePrice;
    
    //매출 단가
    private int sluntPrice;
    
    //비고
    private String bigo;

	public InverterInfoVo(String manufacturer, String productName, double outputCapacity, String certified,
			int maximumInputVoltage, String inputVoltageRangeVariation, String inputString, double weight,
			double maximumEfficiency, String externalSize, String freeGuarantee, int purchasePrice, int sluntPrice) {
		super();
		this.manufacturer = manufacturer;
		this.productName = productName;
		this.outputCapacity = outputCapacity;
		this.certified = certified;
		this.maximumInputVoltage = maximumInputVoltage;
		this.inputVoltageRangeVariation = inputVoltageRangeVariation;
		this.inputString = inputString;
		this.weight = weight;
		this.maximumEfficiency = maximumEfficiency;
		this.externalSize = externalSize;
		this.freeGuarantee = freeGuarantee;
		this.purchasePrice = purchasePrice;
		this.sluntPrice = sluntPrice;
	}
    
   
    
}
