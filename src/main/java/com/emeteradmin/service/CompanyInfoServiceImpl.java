package com.emeteradmin.service;


import com.emeteradmin.dto.CompanyBranchDto;
import com.emeteradmin.entity.CompanyInfo;
import com.emeteradmin.repository.CompanyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CompanyInfoServiceImpl implements CompanyInfoService {

    @Autowired
    CompanyInfoRepository companyInfoRepository;

    @Override
    public List<CompanyBranchDto> getAllCompanyWithBranch() {
        List<CompanyBranchDto> companyBranchDtoList = new ArrayList<CompanyBranchDto>();
        List<CompanyInfo> companyInfoList = companyInfoRepository.findAll();
        for (CompanyInfo cinfo : companyInfoList) {
            CompanyBranchDto companyBranchDto = new CompanyBranchDto();
            companyBranchDto.setCbname(cinfo.getCi_name() + " - " + cinfo.getCi_branch());
            companyBranchDto.setCbid(cinfo.getCi_id());
            companyBranchDto.setCbparentid(cinfo.getCi_parent_id());
            companyBranchDtoList.add(companyBranchDto);
        }
        return companyBranchDtoList;
    }

    @Override
    public Optional<CompanyInfo> findById(String ciId) {
        return companyInfoRepository.findById(ciId);
    }

    @Override
    public List<CompanyInfo> findall() {
        return companyInfoRepository.findAll();
    }

    @Override
    public void save(CompanyInfo companyInfo) {
        companyInfoRepository.save(companyInfo);
    }

    @Override
    public void deleteById(String ciId) {
        companyInfoRepository.deleteById(ciId);
    }
}
