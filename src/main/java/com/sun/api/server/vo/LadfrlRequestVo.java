package com.sun.api.server.vo;

import lombok.Data;

@Data
public class LadfrlRequestVo {

    // 부동산 고유번호
    private String pnu;

    // 검색 건수
    private String numOfRows;

    // 페이지 번호
    private String pageNo;

}
