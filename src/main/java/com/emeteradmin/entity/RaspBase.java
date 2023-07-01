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
@DynamicInsert
@Table(name = "raspbase")
public class RaspBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rb_id")
    private Long rb_id;

    @Column(name = "rb_macid")
    private String rb_macid;

    @Column(name = "rb_manu_name")
    private String rb_manufacturer_name;

    @Column(name = "rb_model")
    private String rb_model;

    @Column(name = "rb_connection_strut")
    private String rb_connection_strut;

    @Column(name = "rb_os_ver")
    private String rb_os_version;

    @Column(name = "rb_desc")
    private String rb_description;

    @Column(name = "rb_active_status")
    private String rb_active_status;

    @Column(name = "rb_active_date")
    private Date rb_active_date;

    @Column(name = "rb_inactive_date")
    private Date rb_inactive_date;

    @Column(name = "created_date")
    private Date created_date;

    @Column(name = "last_updated_date")
    private Date last_updated_date;

    @Column(name = "created_user")
    private String created_user;

    @Column(name = "updated_user")
    private String updated_user;

    @Column(name = "rb_flag")
    private int rb_flag;

    @Column(name = "rb_status")
    private int rb_status;


}
