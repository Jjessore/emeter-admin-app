package com.emeteradmin.service;

import com.emeteradmin.entity.MeterBase;
import com.emeteradmin.repository.MeterBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class MeterBaseServiceImpl implements  MeterBaseService{

    @Autowired
    MeterBaseRepository meterBaseRepository;

    @Override
    public List<MeterBase> findall() {
        return meterBaseRepository.findAll();
    }

    @Override
    public void save(MeterBase meterBase) {
        meterBaseRepository.save(meterBase);
    }

    @Override
    public Optional<MeterBase> findById(Long mbId) {
        return meterBaseRepository.findById(mbId);
    }

    @Override
    public void deleteById(Long mbId) {
        meterBaseRepository.deleteById(mbId);
    }


}
