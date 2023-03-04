package com.madon.demo.repository;

import com.madon.demo.entity.CompagneFonds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompagneFondsRepo extends JpaRepository<CompagneFonds, Long> {
}
