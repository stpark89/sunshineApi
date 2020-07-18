package com.sun.api.server.vo;

import lombok.Data;

@Data
public class SmpVo {

    // 기간
    private String term;
    //가중 평균
    private double WeightedAverage;
}
