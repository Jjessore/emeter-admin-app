package com.emeteradmin.repository;

import com.emeteradmin.dto.CompanyBranchDto;
import com.emeteradmin.entity.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyInfoRepository extends JpaRepository<CompanyInfo, String> {

}
