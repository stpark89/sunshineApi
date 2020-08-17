package com.sun.api.server.vo.fs;

import lombok.Data;

/**
 * 건축물 상세정보 조회
 * ===================================================================
 * 건축면적(㎡)	archArea	NUMBER(19,9)	0	15324.37	건축면적(㎡)
 * 건폐율(%)	bcRat	NUMBER(19,9)	0	0	건폐율(%)
 * 연면적(㎡)	totArea	NUMBER(19,9)	0	223939	연면적(㎡)
 * 용적률(%)	vlRat	NUMBER(19,9)	0	0	용적률(%)
 * 건축물명   bldNm    VARCHAR
 * 기타용도 etcPurps
 */
@Data
public class BuildingDetailResponseVo {

    private double archArea;

    private double bcRat;

    private double totArea;

    private double vlRat;

    private String bldNm;

    private String etcPurps;
}
