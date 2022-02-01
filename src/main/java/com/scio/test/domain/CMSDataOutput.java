package com.scio.test.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CMSDataOutput {

    private String region;
    private String regionCode;
    private Integer period;
    private Double pctHospitalsMu;

}
