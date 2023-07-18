package com.emeteradmin.service;

import com.emeteradmin.entity.RaspBase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RaspBaseService {
    List<RaspBase> findall();

    void save(RaspBase raspBase);


    void deleteById(Long rbId);

    Optional<RaspBase> findById(Long rbId);
}
