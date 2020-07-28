package com.sun.api.server.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoadApiVo {

    private String currentPage;

    private String countPerPage;

    private String keyword;

    private String resultType;

}
