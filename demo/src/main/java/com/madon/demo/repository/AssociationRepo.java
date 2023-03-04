package com.madon.demo.repository;
import com.madon.demo.entity.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociationRepo extends JpaRepository<Association, Long>{
    Association findByRef(String ref);
}
