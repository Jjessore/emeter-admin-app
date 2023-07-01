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
@Table(name = "compinfo")
public class CompanyInfo {

        @Id
        @Column(name="ci_id")
        private String ci_id;

        @Column(name="ci_name")
        private String ci_name;

        @Column(name="ci_branch")
        private String ci_branch;

        @Column(name="ci_parent_id")
        private String ci_parent_id;

        @Column(name="ci_add1")
        private String ci_add1;

        @Column(name="ci_add2")
        private String ci_add2;

        @Column(name="ci_town")
        private String ci_town;

        @Column(name="ci_state")
        private String ci_state;

        @Column(name="ci_pin")
        private String ci_pin;

        @Column(name="ci_admin_mobile")
        private String ci_admin_mobile;

        @Column(name="ci_admin_email")
        private String ci_admin_email;

        @Column(name="ci_sms_mobiles")
        private String ci_sms_mobiles;

        @Column(name="ci_emails")
        private String ci_emails;

        @Column(name="ci_meter_count")
        private int ci_meter_count;

        @Column(name="created_date")
        private Date created_date;

        @Column(name="last_updated_date")
        private Date last_updated_date;

        @Column(name="created_user")
        private String created_user;

        @Column(name="updated_user")
        private String updated_user;

        @Column(name="ci_flag")
        private int ci_flag;

        @Column(name="ci_status")
        private int ci_status;

}
