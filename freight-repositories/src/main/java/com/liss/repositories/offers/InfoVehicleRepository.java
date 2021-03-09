package com.liss.repositories.offers;

import com.liss.entities.offers.InfoVehicleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoVehicleRepository extends JpaRepository<InfoVehicleEntity, String> {

    /* get one InfoVehicle*/

    @Query("SELECT iv FROM InfoVehicle iv where iv.id=:id")
    public InfoVehicleEntity getInfoVehicleById(@Param("id") String id);

    /* get all InfoVehicle */

    @Query("SELECT iv FROM InfoVehicle iv WHERE iv.isDeleted = false AND UPPER(iv.mpl) like CONCAT('%', UPPER(:mpl), '%')"
            + " ORDER BY mpl ASC")
    public  Page<InfoVehicleEntity>getAllInfoVehicle(@Param("mpl") String mpl, Pageable pageable);

    @Query("SELECT iv FROM InfoVehicle iv WHERE iv.isDeleted = false AND UPPER(iv.mpl) = UPPER(:mpl) ")
    public InfoVehicleEntity findByMpl(@Param("mpl") String mpl);

}
