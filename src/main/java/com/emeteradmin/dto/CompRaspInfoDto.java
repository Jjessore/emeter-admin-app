package com.emeteradmin.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompRaspInfoDto {

    private Long raspId;
    private String raspMacId;
    private String raspModel;
    private String raspConnStruct;
    private String raspOsVer;
    private String raspDesc;
    private String raspStatus;
    private String raspManfName;
    private String cmpId;
    private String cmpName;
    private String cmpBranch;
    private Long cmpraspId;

}
