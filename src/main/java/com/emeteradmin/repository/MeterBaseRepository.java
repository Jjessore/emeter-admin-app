package com.emeteradmin.repository;

import com.emeteradmin.entity.MeterBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MeterBaseRepository extends JpaRepository<MeterBase, Long> {

}
