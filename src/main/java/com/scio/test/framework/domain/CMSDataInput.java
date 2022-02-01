package com.scio.test.framework.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CMSDataInput {

    private String region;
    private String regionCode;
    private Integer period;
    private Double pctMdPaNpMuAiu;
    private Double pctMdPaNpMu;
    private Double pctMdMuAiu;
    private Double pctMdMu;
    private Double pctNpMuAiu;
    private Double pctNpMu;
    private Double pctPaMuAiu;
    private Double pctPaMu;
    private Double pctHospitalsMuAiu;
    private Double pctHospitalsMu;
    private Double pctCahSmallRuralMuAiu;
    private Double pctCahSmallRuralMu;

}
