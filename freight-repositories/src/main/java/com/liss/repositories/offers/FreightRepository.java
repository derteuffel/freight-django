package com.liss.repositories.offers;

import com.liss.entities.offers.FreightEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface FreightRepository extends JpaRepository<FreightEntity, String> {

    /* Debut implémentation des filtres des données */
    /* fin implémentation des filtres des données */



    /**@author Issofa
     * compte le nombre total des frets
     */
    @Query("select COUNT(f) From Freight f ")
    Long totalElements();

    /**@author Issofa
     * compte le nombre des frets actifs
     */
    @Query("select COUNT(f) From Freight f where f.enable=true")
    Long totalElementsActif();

    /**@author Issofa
     * compte le nombre des frets désactivé
     */
    @Query("select COUNT(f) From Freight f where f.enable=false")
    Long totalElementDeleted();

    @Transactional
    @Modifying
    @Query(value="delete from destinations where freight_id =:x", nativeQuery=true)
    void  deletetrajetOnFreight(@Param("x")String code);

    @Transactional
    @Modifying
    @Query(value="update destinations set principal=true where destinations.id = :x", nativeQuery=true)
    void setPrincipalToLastunloading(@Param("x") String code);

    /** get One freight **/

    @Query("SELECT f FROM Freight f WHERE f.id =:id")
    public FreightEntity getFreightById(@Param("id") String id);

    /** get all freight **/

    @Query("SELECT f FROM Freight f WHERE f.isDeleted = false ")
    public Page<FreightEntity>findAllFreight(Pageable pageable);

    Page<FreightEntity> findAllByUser_Email(String email, Pageable pageable);

    /** get All Company by param **/
/*
    @Query("SELECT f FROM  Freight f WHERE f.isDeleted = false AND UPPER(f.infoVehicle.mpl) LIKE CONCAT('%',UPPER(:infoVehicle),'%') "
          + " AND f.vehicleSize.id = :id"
          + " AND UPPER(f.user.name) LIKE CONCAT('%', UPPER(:user) )")
    public Page<FreightEntity>getAllFreightInfoVehicle(Pageable pageable, @Param("infoVehicle")String infoVehicle, @Param("vehicleSize")String vehicleSize, @Param("user")String user);
*/


}
