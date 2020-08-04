package com.sun.api.server.vo;

import lombok.Data;

/**
 * 좌표 API Request Vo
 */
@Data
public class LocationApiVo {
    private String confmKey;

    private String admCd;

    private String rnMgtSn;

    private String udrtYn;

    private String resultType;

    private int buldMnnm;

    private int buldSlno;
}
