package com.emeteradmin.service;

import com.emeteradmin.dto.CompRaspInfoProjection;
import com.emeteradmin.entity.CompanyRaspInfo;
import com.emeteradmin.repository.CompanyRaspInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompanyRaspInfoServiceImpl implements CompanyRaspInfoService{

    @Autowired
    CompanyRaspInfoRepository companyRaspInfoRepository;

    @Override
    public void save(CompanyRaspInfo companyRaspInfo) {
            companyRaspInfoRepository.save(companyRaspInfo);
    }
    @Override
    public List<CompRaspInfoProjection> findRaspWithCompany() {
        return companyRaspInfoRepository.findRaspWithCompany();
    }

    @Override
    public CompRaspInfoProjection findRaspWithCompanyById(Long rbId) {
        return companyRaspInfoRepository.findRaspWithCompanyById(rbId);
    }

    @Override
    public Optional<CompanyRaspInfo> findById(Long crid) {
        return companyRaspInfoRepository.findById(crid);
    }

    @Override
    public void UpdateRaspCompany(Long crid, String compid) {
        companyRaspInfoRepository.UpdateRaspCompany(crid, compid);
    }

}
