package com.emeteradmin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "meterbase")
public class MeterBase {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="mb_id")
        private Long meter_base_id;

        @Column(name="mb_name",nullable = false)
        private String mb_meter_name;

        @Column(name="mb_manu_name",nullable = false)
        private String mb_manufacturer_name;

        @Column(name="mb_model")
        private String mb_model;

        @Column(name="mb_model_prgname",nullable = false)
        private String mb_model_program_name;

        @Column(name="mb_meternumber")
        private String mb_meternumber;

        @Column(name="mb_meter_desc")
        private String mb_meter_description;

        @Column(name="mb_meter_status",nullable = false)
        private String mb_meter_status;

        @Column(name="mb_active_date")
        private Date mb_active_date;

        @Column(name="mb_inactive_date")
        private Date mb_inactive_date;

        @Column(name="created_date")
        private Date mb_created_date;

        @Column(name="last_updated_date")
        private Date mb_last_updated_date;

        @Column(name="created_user")
        private String mb_created_user;

        @Column(name="updated_user")
        private String mb_updated_user;

        @Column(name="mb_flag")
        private int mb_flag;

        @Column(name="mb_status")
        private int mb_status;


}
