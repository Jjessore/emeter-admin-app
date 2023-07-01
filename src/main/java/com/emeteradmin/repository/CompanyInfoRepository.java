package com.emeteradmin.repository;

import com.emeteradmin.entity.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyInfoRepository extends JpaRepository<CompanyInfo, String> {

}
