package com.madon.demo.repository;
import com.madon.demo.entity.Dons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonsRepo extends JpaRepository<Dons, Long> {
}
