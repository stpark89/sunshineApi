package com.sun.api.server.vo.fs;

import lombok.Data;

/**
 페이지 번호	    pageNo	4	필수	1	페이지번호
 한 페이지 결과 수	numOfRows	4	필수	10	한 페이지 결과 수
 시/도	        addrDo	30	옵션	전라남도	시/도
 시	            addrSi	30	옵션	나주시	시
 구/군	        addrGu	30	옵션	서구	구/군
 동/면	        addrLidong	20	옵션	경현동	동/면
 리	            AddrLi	20	옵션	석전리	리
 상세번지	        addrJibun	20	옵션	337-4	상세번지
 변전소코드	    substCd	5	옵션	5063	변전소코드
 */
@Data
public class StrategicInformationRequestVo {

    private int pageNo;
    private int numOfRows;
    private String addrDo;
    private String addrSi;
    private String addrGu;
    private String addrLidong;
    private String addrLi;
    private String addrJibun;
    private String substCd;

}
