package com.sun.api.server.vo;

import lombok.Data;

@Data
public class BsdPriceResponseVo {

    // 용도 지역명
    private String prposAreaNm;

    // 용도 지구명
    private String prposDstrcNm;

    // 토지면적
    private String ladAr;

    // 공시지가
    private String ladPblntfPclnd;

    // 총 공시지 ( 토지면적 * 공시지가 )
    private String totalLadPblntfPclnd;

}
