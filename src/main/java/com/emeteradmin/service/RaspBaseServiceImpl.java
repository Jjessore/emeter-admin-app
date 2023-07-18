package com.emeteradmin.service;


import com.emeteradmin.entity.RaspBase;
import com.emeteradmin.repository.RaspBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RaspBaseServiceImpl implements RaspBaseService {

    @Autowired
    RaspBaseRepository raspBaseRepository;

    @Override
    public List<RaspBase> findall() {
        return raspBaseRepository.findAll();
    }

    @Override
    public void save(RaspBase raspBase) {
        raspBaseRepository.save(raspBase);
    }

    @Override
    public Optional<RaspBase> findById(Long rbId) {
        return raspBaseRepository.findById(rbId);
    }

    @Override
    public void deleteById(Long rbId) {
        raspBaseRepository.deleteById(rbId);
    }
}
