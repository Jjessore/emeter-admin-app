package com.emeteradmin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRaspDto {

    private String compid;
    private String raspmacid;
    private String raspstatus;
    private Long crid;

}
