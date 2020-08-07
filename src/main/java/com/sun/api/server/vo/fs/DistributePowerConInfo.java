package com.sun.api.server.vo.fs;

import lombok.Data;

import java.util.List;

/**
 결과코드	resultCode	2	필수	00	결과코드
 결과메시지	resultMsg	50	필수	NORMAL SERVICE.	결과메시지
 한 페이지 결과 수	numOfRows	4	필수	10	한 페이지 결과 수
 페이지 번호	pageNo	4	필수	1	페이지번호
 전체 결과 수	totalCount	4	필수	8	전체 결과 수
 변전소명	substNm	20	필수	나주	변전소명
 MTR번호	mtrNo	10	필수	2	MTR번호
 DL명	dlNm	20	필수	시내	DL명
 변전소 누적연계용량	substPwr	100	필수	244043	변전소 누적연계용량
 변압기 누적연계용량	mtrPwr	100	필수	83314	변압기 누적연계용량
 DL누적연계용량	dlPwr	100	필수	396	DL누적연계용량
 변전소 용량	jsSubstPwr	100	필수	5000	변전소 용량
 변압기 용량	jsMtrPwr	100	필수	0	변압기 용량
 DL 용량	jsDlPwr	50	필수	0	DL 용량
 변전소 여유용량	vol_1	20	필수	0	변전소 여유용량
 변압기 여유용량	vol_2	20	필수	0	변압기 여유용량
 DL 여유용량	vol_3	20	필수	0	DL 여유용량
 변전소코드	substCd	5	필수	5063	변전소코드
 DL코드	dlCd	3	필수	04	DL코드
 */
@Data
public class DistributePowerConInfo {
    private int resultCode;
    private String resultMsg;
    private int numOfRows;
    private int pageNo;
    private int totalCount;
    private List<DistributePowerVo> items;

}