package com.mp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mp.entity.Institutions;

@Repository
public interface InstitutionsRepository extends JpaRepository<Institutions, Integer> {
    // No changes needed unless you want custom queries
}
