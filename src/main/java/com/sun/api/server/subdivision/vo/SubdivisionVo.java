package com.sun.api.server.subdivision.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class SubdivisionVo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String subdivisionId;

    @ElementCollection(targetClass=String.class)
    private List<String> imageUrl;
    private String location;
    private int years;
    private Double kw;
    private Double yields;
    private int price;
    private int averageMonthlySales;
    private Double powerGenerationTime;
    private Double developmentStartMonth;
    private Date recWeight;
    private String recContractType;
    private String buildingType;
    private int operatingCost;
    @ElementCollection(targetClass=String.class)
    private List<String> fixedExpenses;
    private String panel;
    private String inverter;
    private String structureType;
    private String landExten;
    private int remainsLoanCost;
    private String loanLinkage;
    private boolean salesStatus;

}
