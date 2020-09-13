package com.sun.api.server.vo.module;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class ModuleInfoVo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // 1.제조사
    private String manufacturer;

    // 2.정류
    private String moduleKind;

    //3.품명
    private String productName;

    //4.최대 출력
    private int maximumPower;

    //5.개방전압
    private double openCircuitVoltage;

    //6.직렬
    //private int sirial;

    //7.단락전류
    private double shortCircuitCurrent;

    //8.효율
    private double efficiency;

    //9.최대시스템전압
    private int systemVoltage;

    //10.모듈사이즈
    private String moduleSize;

    //11.모듈무게
    private double moduleWeight;

    //12.제품보증(년)
    private int productWarranty;

    //13.출력보증
    private String outputWarranty;

    //14.Wp당 단가
    private int wpUnitPrice;

    //15.모듈매입단가
    private int moudlePurchaseUnitPrice;

    //16.모듈판매단가
    private int moudleSaleUnitPrice;

    //17.비고
    private String bigo;

    //KW
    private int kw;
    
    //직렬 
    private int serial;
    
    //병렬 
    private int parallel;
    
    //용량 
    private double capacity;
    
    //합계용량 
    private double totalCapacity;

	public ModuleInfoVo(String manufacturer, String moduleKind, String productName, int maximumPower,
			double openCircuitVoltage, double shortCircuitCurrent, double efficiency, int systemVoltage,
			String moduleSize, double moduleWeight, int productWarranty, String outputWarranty, int wpUnitPrice,
			int kw, int serial, int parallel,
			double capacity, double totalCapacity, int moudlePurchaseUnitPrice, int moudleSaleUnitPrice, String bigo) {
		super();
		this.manufacturer = manufacturer;
		this.moduleKind = moduleKind;
		this.productName = productName;
		this.maximumPower = maximumPower;
		this.openCircuitVoltage = openCircuitVoltage;
		//this.sirial = sirial;
		this.shortCircuitCurrent = shortCircuitCurrent;
		this.efficiency = efficiency;
		this.systemVoltage = systemVoltage;
		this.moduleSize = moduleSize;
		this.moduleWeight = moduleWeight;
		this.productWarranty = productWarranty;
		this.outputWarranty = outputWarranty;
		this.wpUnitPrice = wpUnitPrice;
		this.kw = kw;
		this.serial = serial;
		this.parallel = parallel;
		this.capacity = capacity;
		this.totalCapacity = totalCapacity;
		this.moudlePurchaseUnitPrice = moudlePurchaseUnitPrice;
		this.moudleSaleUnitPrice = moudleSaleUnitPrice;
		this.bigo = bigo;
	}
    
    
    
    

}
