package com.sun.api.server.vo.fs;

import lombok.Data;

/**
 * 여기서 중요한 것은
 * 컨버팅한 데이터 => 행안부에서 제공하는 xPoint 는 카카오 맵의 y 값에 들어가야함.
 *                              yPoint 는 카카오 맵의 x 값에 들어가야함.
 */
@Data
public class ConvertXYmapVo {

    // 1. 좌표 API 에서 받아온 xPoint -> yPoint
    private String xPoint;

    // 2. 좌표 API 에서 받아온 yPoint -> xPoint
    private String yPoint;
}
