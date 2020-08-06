package com.sun.api.server.vo;

import lombok.Data;

/**
기준년도	    stdrYear	4	기준년도(YYYY: 4자리)
요청구분	    reqLvl	    1	요청구분(1: 시도단위, 2: 시군구단위, 3: 읍면동리단위)
법정동코드	    ldCode	    10	-> 법정동코드(reqLvl값이 1일 경우: 해당 없음, 2일 경우: 2~5자리, 3일 경우: 2~10자리)
                            -> 행안부 주소 검색 결과중 행정구역 코드값을 프론트에서 셋팅해서 넘겨줌

응답결과 형식	format	    5	xml	응답결과 형식(xml 또는 json)
검색건수	    numOfRows	4	검색건수
페이지 번호	pageNo	    4	페이지 번호
**/

@Data
public class BsdPriceRequestVo {
    private String stdrYear;
    private String reqLvl;
    private String ldCode;
    private String format;
    private int numOfRows;
    private int pageNo;
}
