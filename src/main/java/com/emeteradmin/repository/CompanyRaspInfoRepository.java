package com.emeteradmin.repository;

import com.emeteradmin.dto.CompRaspInfoProjection;
import com.emeteradmin.entity.CompanyRaspInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRaspInfoRepository extends JpaRepository<CompanyRaspInfo,Long> {


        @Query (value="select c.rb_id raspId, c.rb_macid raspMacId, c.rb_model raspModel,c.rb_connection_strut raspConnStruct," +
                      "c.rb_os_ver raspOsVer,c.rb_desc raspDesc,c.rb_active_status raspStatus,c.rb_manu_name raspManfName," +
                      "b.ci_id cmpId, b.ci_name cmpName, b.ci_branch cmpBranch from elecmet.compraspinfo a join elecmet.compinfo b on a.cr_compinfo_id = b.ci_id " +
                      "right join elecmet.raspbase c on a.cr_rasp_macid = c.rb_macid", nativeQuery = true)
        List<CompRaspInfoProjection> findRaspWithCompany();

        @Query (value="select * from elecmet.vw_compraspinfo where raspId = ?1", nativeQuery = true)
        CompRaspInfoProjection findRaspWithCompanyById(Long rbId);

        @Modifying
        @Transactional
        @Query("Update CompanyRaspInfo c set cr_companyinfo_id = :compid where cr_id = :crid ")
        public void UpdateRaspCompany(Long crid, String compid);
}
