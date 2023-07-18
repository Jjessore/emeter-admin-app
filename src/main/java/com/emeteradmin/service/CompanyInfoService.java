package com.emeteradmin.service;

import com.emeteradmin.dto.CompanyBranchDto;
import com.emeteradmin.entity.CompanyInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface CompanyInfoService {
    List<CompanyBranchDto> getAllCompanyWithBranch();

    Optional<CompanyInfo> findById(String ciId);

    List<CompanyInfo> findall();

    void save(CompanyInfo companyInfo);

    void deleteById(String ciId);
}
