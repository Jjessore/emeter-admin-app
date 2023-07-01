package com.emeteradmin.repository;

import com.emeteradmin.entity.RaspBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaspBaseRepository extends JpaRepository<RaspBase, Long> {
}
