package com.madon.demo.repository;
import com.madon.demo.entity.Donateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonateurRepository extends JpaRepository<Donateur, Long>{
}
