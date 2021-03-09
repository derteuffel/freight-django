package com.liss.repositories.staticclass;

import com.liss.entities.staticclass.VehicleSizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleSizeRepository extends JpaRepository<VehicleSizeEntity, String> {
}
