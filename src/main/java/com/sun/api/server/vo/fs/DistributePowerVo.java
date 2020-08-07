package com.sun.api.server.vo.fs;

import lombok.Data;

@Data
public class DistributePowerVo {
    private String substNm;
    private int mtrNo;
    private String dlNm;
    private int substPwr;
    private int jsMtrPwr;
    private int jsDlPwr;
    private int vol_1;
    private int vol_2;
    private int vol_3;
    private String substCd;
    private String dlCd;
}
