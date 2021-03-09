package com.liss.repositories.staticclass;

import com.liss.entities.staticclass.AdditionalEquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalEquipmentRepository extends JpaRepository<AdditionalEquipmentEntity, String> {
}
