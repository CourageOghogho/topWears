package com.topwears.topwears.repositories;


import com.topwears.topwears.models.entities.DesignEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignRepository extends JpaRepository<DesignEntity,Long> {
}
