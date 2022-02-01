package com.scio.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CMSData implements Serializable {

    private static final long serialVersionUID = -1997078231256063783L;

    public static final Integer DEFAULT_YEAR = 2014;

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
