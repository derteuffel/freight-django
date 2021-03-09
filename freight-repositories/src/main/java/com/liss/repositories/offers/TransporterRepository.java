package com.liss.repositories.offers;

import com.liss.entities.offers.TransporterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransporterRepository extends JpaRepository<TransporterEntity, String> {

    @Query(" SELECT COUNT (t) FROM Transporter t ")
    Long totalElements();

    /**@author Patrick
     * compte le nombre des commissionnaires actifs
     */
    @Query("select COUNT(t) From Transporter t where t.enable=true")//
    Long totalElementsActif();

    /**@author Patrick
     * Compte le nombre  des transporteurs desactivé
     */
    @Query(" SELECT COUNT (t) FROM Transporter t where t.enable = false ")
    Long totalEletementDeleted();


}
