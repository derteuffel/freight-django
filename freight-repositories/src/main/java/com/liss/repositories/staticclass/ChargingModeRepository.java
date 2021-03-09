package com.liss.repositories.staticclass;

import com.liss.entities.staticclass.ChargingModeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargingModeRepository extends JpaRepository<ChargingModeEntity, String> {
}
