package com.sun.api.server.packageProduct.vo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 패키지 상품 Vo
 */
@Data
@Entity
public class PackageProductVo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    // 패키지이름
    private String name;
    // 가격
    private int price;
    // 할인율
    private Double rateDiscount;
    // 기준용량
    private Double kw;

    // 모듈 아이디
    private long moduleId;
    //모듈 제조사
    private String moduleManufacturer;
    //모듈 품명
    private String moduleProductName;

    // 인버터 아이디
    private long inverterId;
    // 인버터 제조사
    private String inverterManufacturer;
    // 인버터 품명
    private String inverterProductName;

}
