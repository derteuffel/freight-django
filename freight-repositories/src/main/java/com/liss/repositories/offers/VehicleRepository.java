package com.liss.repositories.offers;

import com.liss.entities.offers.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, String> {

    /**@author Issofa
     * compte le nombre total des frets
     */
    @Query("select COUNT(v) From Vehicle v ")
    Long totalElements();

    /**@author Issofa
     * compte le nombre des frets actifs
     */
    @Query("select COUNT(v) From  Vehicle v where v.enable=true")
    Long totalElementsActif();

    /**@author Issofa
     * compte le nombre des frets désactivé
     */
    @Query("select COUNT(v) From Vehicle v where v.enable=false")
    Long totalElementDeleted();

    @Transactional
    @Modifying
    @Query(value="delete from destinations where vehicle_id =:x", nativeQuery=true)
    void  deletetrajetOnVehicle(@Param("x")String code);

    @Transactional
    @Modifying
    @Query(value="update destinations set principal=true where destination.id = :x", nativeQuery=true)
    void setPrincipalToLastunloading(@Param("x") String code);


}
