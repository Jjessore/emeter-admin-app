package com.emeteradmin.service;

import com.emeteradmin.entity.MeterBase;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MeterBaseService {
    public List<MeterBase> findall();

    void save(MeterBase meterBase);

    Optional<MeterBase> findById(Long mbId);

    void deleteById(Long mbId);
}
