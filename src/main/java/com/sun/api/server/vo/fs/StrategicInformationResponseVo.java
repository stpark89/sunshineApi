package com.sun.api.server.vo.fs;

import lombok.Data;

@Data
public class StrategicInformationResponseVo {
    // 변전소명
    private String substNm;

    // 변전소 여유용량
    private String vol_1;

    private String vol_2;

    private String vol_3;

    // 변전소 누적연계용량
    private String substPwr;

    // 변압기 누적연계용량
    private String mtrPwr;

    // DL 명
    private String dlNm;

    // DL누적연계용량
    private String dlPwr;
}
