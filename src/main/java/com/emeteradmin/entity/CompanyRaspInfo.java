package com.emeteradmin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Table(name = "compraspinfo")
public class CompanyRaspInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cr_id")
    private long cr_id;
    @Column(name = "cr_compinfo_id")
    private String cr_companyinfo_id;

    @Column(name = "cr_rasp_macid")
    private String cr_rasp_macid;

    @Column(name = "cr_rasp_status")
    private String cr_rasp_status;

    @Column(name = "cr_active_date")
    private Date cr_active_date;

    @Column(name = "cr_inactive_date")
    private Date cr_inactive_date;

    @Column(name = "created_date")
    private Date created_date;

    @Column(name = "last_updated_date")
    private Date last_updated_date;

    @Column(name = "created_user")
    private String created_user;

    @Column(name = "updated_user")
    private String updated_user;

    @Column(name = "cr_flag")
    private int cr_flag;

    @Column(name = "cr_status")
    private int cr_status;

}
