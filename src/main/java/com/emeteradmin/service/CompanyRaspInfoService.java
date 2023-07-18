package com.emeteradmin.service;

import com.emeteradmin.dto.CompRaspInfoProjection;
import com.emeteradmin.entity.CompanyRaspInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CompanyRaspInfoService {
    void save(CompanyRaspInfo companyRaspInfo);

    List<CompRaspInfoProjection> findRaspWithCompany();

    CompRaspInfoProjection findRaspWithCompanyById(Long rbId);

    Optional<CompanyRaspInfo> findById(Long crid);

    void UpdateRaspCompany(Long crid, String compid);
}
