package com.sun.api.server.vo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class SmpVo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    // 기간
    private String term;
    //가중 평균
    private double WeightedAverage;
    //육지(0) 제주(1) 구분
    private int division;
}
