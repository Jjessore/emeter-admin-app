package com.emeteradmin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="compmeterinfo")
public class CompanyMeterInfo {

    @Id
    @Column(name = "cm_id")
    private Long cm_id;


    /*
    ci_id,
    cm_cur_rasp_macid,
    cm_phy_meter_id,
    cm_pk_meter_id,
    cm_meter_status,
    cm_active_date,
    cm_inactive_date,
    cm_meter_name,
    cm_meter_block,
    cm_meter_dept,
    cm_meter_divi,
    cm_meter_team,
    cm_meter_connmachine,
    cm_meter_desc,
    mb_name,
    mb_model,
    mb_model_prgname,
    created_date,
    last_updated_date,
    created_user,
    updated_user,
    cm_flag,
    cm_status */


}
