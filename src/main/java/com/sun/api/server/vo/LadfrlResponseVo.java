package com.sun.api.server.vo;

import lombok.Data;

@Data
public class LadfrlResponseVo {

    // 법정동명
    private String ldCodeNm;

    // 지번주소)
    private String mnnmSlno;

    // 지목
    private String lndcgrCodeNm;

    // 면적 (평)  면적(m2) % 3.305785
    private String lndpclArPyung;

    // 면적 (m2)
    private String lndpclAr;

    // 소유 구분
    private String posesnSeCodeNm;

    // 소유(공유)인수(명)
    private String cnrsPsnCo;



}
